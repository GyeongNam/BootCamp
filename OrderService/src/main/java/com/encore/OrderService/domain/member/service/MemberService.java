package com.encore.OrderService.domain.member.service;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.repository.MemberRepository;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.resdto.MemberResDTO;
import jakarta.persistence.EntityExistsException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(
            MemberRepository memberRepository
    ){
        this.memberRepository = memberRepository;
    }

    public Member findById (Long id) throws EntityExistsException{
        return memberRepository.findById(id).orElseThrow(()->new EntityExistsException("존재하지 않는 회원 아이디 입니다."));
    }

    public MemberResDTO register(MemberReqCreateDTO memberReqCreateDTO) throws IllegalArgumentException {
        if(memberRepository.findByEmail(memberReqCreateDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("중복 이메일 입니다.");
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
}
