package com.encore.Spring_basic.service;

import com.encore.Spring_basic.domain.Member;
import com.encore.Spring_basic.domain.MemberRequestDTO;
import com.encore.Spring_basic.domain.MemberResponseDTO;
import com.encore.Spring_basic.repository.MemberRepository;
import com.encore.Spring_basic.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class MemberService {
    private long total_id = 0;

    private final MemberRepository memberRepository;

    @Autowired
    public  MemberService(MemoryMemberRepository memoryMemberRepository){
        this.memberRepository = memoryMemberRepository;
    }

    public List<MemberResponseDTO> members (){
        List<Member> memberList = memberRepository.members();
        List<MemberResponseDTO> dtolist = new ArrayList<>();
        MemberResponseDTO dto;
        for(Member m :memberList){
            dto = new MemberResponseDTO();
            dto.setId(m.getId());
            dto.setName(m.getName());
            dto.setEmail(m.getEmail());
            dto.setPassword(m.getPassword());
            dtolist.add(dto);
        }
        return dtolist;
    }

    public void memberCreate(MemberRequestDTO memberRequestDTO){
        Member member = new Member(
                total_id++,
                memberRequestDTO.getName(),
                memberRequestDTO.getEmail(),
                memberRequestDTO.getPassword(),
                LocalDateTime.now()
        );
        memberRepository.memberCreate(member);
    }

    public MemberResponseDTO memberFindById(long id) {
        Member m = memberRepository.memberFindById(id);
        MemberResponseDTO dto =  new MemberResponseDTO();
        dto.setId(m.getId());
        dto.setName(m.getName());
        dto.setEmail(m.getEmail());
        dto.setPassword(m.getPassword());
        dto.setCreate_at(m.getCreate_at());
        return dto;
    }
}
