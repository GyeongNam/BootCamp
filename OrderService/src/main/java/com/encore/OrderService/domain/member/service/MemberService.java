package com.encore.OrderService.domain.member.service;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.repository.MemberRepository;
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
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final OrderingRepository orderingRepository;

    @Autowired
    public MemberService(
            MemberRepository memberRepository,
            OrderingRepository orderingRepository
    ){
        this.memberRepository = memberRepository;
        this.orderingRepository = orderingRepository;
    }

    public Member findById (Long id) throws EntityNotFoundException {
        return memberRepository.findById(id).orElseThrow(()->new EntityNotFoundException("존재하지 않는 회원 아이디 입니다."));
    }

    public MemberResDTO register(MemberReqCreateDTO memberReqCreateDTO) throws DataIntegrityViolationException {
        if(memberRepository.findByEmail(memberReqCreateDTO.getEmail()).isPresent()){
            throw new DataIntegrityViolationException("중복 이메일 입니다.");
        }
        return Member.MemberToMemberResDTO(
                memberRepository.save(
                        MemberReqCreateDTO.MemberReqCreateDTOToMember(memberReqCreateDTO)
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
}
