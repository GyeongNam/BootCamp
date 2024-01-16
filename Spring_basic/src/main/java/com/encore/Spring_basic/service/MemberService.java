package com.encore.Spring_basic.service;

import com.encore.Spring_basic.domain.Member;
import com.encore.Spring_basic.domain.MemberRequestDTO;
import com.encore.Spring_basic.domain.MemberResponseDTO;
import com.encore.Spring_basic.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public  MemberService(MemberMyBatisRepository memberMyBatisRepository){
        this.memberRepository = memberMyBatisRepository;
    }

    public List<MemberResponseDTO> findAll (){
        List<Member> memberList = memberRepository.findAll();
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

    public void save(MemberRequestDTO memberRequestDTO){
        Member member = new Member(
                memberRequestDTO.getName(),
                memberRequestDTO.getEmail(),
                memberRequestDTO.getPassword()
        );
        memberRepository.save(member);
    }

    public MemberResponseDTO findById(long id) throws NoSuchElementException {
        Member m = memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
        MemberResponseDTO dto =  new MemberResponseDTO();
        dto.setId(m.getId());
        dto.setName(m.getName());
        dto.setEmail(m.getEmail());
        dto.setPassword(m.getPassword());
        dto.setCreate_at(m.getCreate_at());
        return dto;
    }
}
