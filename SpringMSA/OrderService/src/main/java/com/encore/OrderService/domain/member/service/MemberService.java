package com.encore.OrderService.domain.member.service;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.repository.MemberRepository;
import com.encore.OrderService.domain.member.reqdto.LoginReqDTO;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.resdto.MemberResDTO;
import com.encore.OrderService.domain.order.domain.Ordering;
import com.encore.OrderService.domain.order.repository.OrderingRepository;
import com.encore.OrderService.domain.order.resdto.OrderingResDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final OrderingRepository orderingRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(
            MemberRepository memberRepository,
            OrderingRepository orderingRepository, PasswordEncoder passwordEncoder
    ){
        this.memberRepository = memberRepository;
        this.orderingRepository = orderingRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member findById (Long id) throws EntityNotFoundException {
        return memberRepository.findById(id).orElseThrow(()->new EntityNotFoundException("존재하지 않는 아이디 입니다."));
    }

    public Member findByEmail (String email) throws IllegalArgumentException {
        return memberRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException("존재하지 않는 이메일 입니다."));
    }

    public MemberResDTO register(MemberReqCreateDTO memberReqCreateDTO) throws DataIntegrityViolationException {
        if(memberRepository.findByEmail(memberReqCreateDTO.getEmail()).isPresent()){
            throw new DataIntegrityViolationException("중복 이메일 입니다.");
        }
        return Member.MemberToMemberResDTO(
                memberRepository.save(
                        MemberReqCreateDTO.MemberReqCreateDTOToMember(memberReqCreateDTO, passwordEncoder)
                )
        );
    }

    public Page<MemberResDTO> memberList(Pageable pageable) {
        Page<Member> memberPage = memberRepository.findAll(pageable);
        return memberPage.map(
                Member::MemberToMemberResDTO
        );
    }

    public Page<OrderingResDTO> memberOrderList(Pageable pageable, Long id) {
        return orderingRepository.findAllByMemberId(pageable,id).map(
                Ordering::OrderingToOrderResDTO
        );
    }

    public Member login(LoginReqDTO loginReqDTO) throws UsernameNotFoundException {
        // 회원가입 여부
        Member member = this.findByEmail(loginReqDTO.getEmail());

        // 패스워드 일치 여부
        if(!passwordEncoder.matches(loginReqDTO.getPassword(), member.getPassword())){
            throw new UsernameNotFoundException("비밀번호 불일치");
        }

        return member;
    }

    public MemberResDTO findByInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return Member.MemberToMemberResDTO(this.findByEmail(email));
    }
}
