package com.encore.Spring_basic.service;

import com.encore.Spring_basic.domain.Member;
import com.encore.Spring_basic.domain.MemberRequestDTO;
import com.encore.Spring_basic.domain.MemberResponseDTO;
import com.encore.Spring_basic.repository.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;


@Service

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public  MemberService(MemberSpringDataJpaRepository memberSpringDataJpaRepository){
        this.memberRepository = memberSpringDataJpaRepository;
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

    /*
    @Transactional 클래스 단위를 붙이면 모든 메서드에 각각 Transactional 적용
    Transactional 을 적용하면 한 다위로 트랜잭션 지정
     */
    @Transactional
    public void save(MemberRequestDTO memberRequestDTO) throws IllegalArgumentException{
        Member member = new Member(
                memberRequestDTO.getName(),
                memberRequestDTO.getEmail(),
                memberRequestDTO.getPassword()
        );
        memberRepository.save(member);

//        Member member = new Member(
//                memberRequestDTO.getName(),
//                memberRequestDTO.getEmail(),
//                memberRequestDTO.getPassword()
//        );
//        memberRepository.save(member);
//        if(member.getName().equals("jo")){
//            throw new IllegalArgumentException();
//        }
    }

    public void update(MemberRequestDTO memberRequestDTO){
        Member m = memberRepository.findById(memberRequestDTO.getId()).orElseThrow(EntityNotFoundException::new);
        m.setName(memberRequestDTO.getName());
        m.setPassword(memberRequestDTO.getPassword());
        memberRepository.save(m);
    }
    public MemberResponseDTO findById(long id) throws EntityNotFoundException {
        Member m = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        MemberResponseDTO dto =  new MemberResponseDTO();
        dto.setId(m.getId());
        dto.setName(m.getName());
        dto.setEmail(m.getEmail());
        dto.setPassword(m.getPassword());
        dto.setCreate_at(m.getCreate_at());
        return dto;
    }

    public void delete (long id){
        Member m = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        memberRepository.delete(m);
    }
}
