package com.encore.OrderService.domain.member.service;

import com.encore.OrderService.domain.member.domain.Member;
import com.encore.OrderService.domain.member.repository.MemberRepository;
import com.encore.OrderService.domain.member.reqdto.MemberReqCreateDTO;
import com.encore.OrderService.domain.member.resdto.MemberResMemberDTO;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public MemberResMemberDTO register(MemberReqCreateDTO memberReqCreateDTO) {
        if(memberRepository.findByEmail(memberReqCreateDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("중복 이메일 입니다.");
        }
        return Member.MemberToMemberResCreateDTO(
                memberRepository.save(
                        MemberReqCreateDTO.MemberReqCreateDTOToMember(memberReqCreateDTO)
                )
        );
    }
}
