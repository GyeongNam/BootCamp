package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private List<Member> memberDB = new ArrayList<>();
    private long total_id = 0;

    @Override
    public List<Member> findAll(){
        return this.memberDB;
    }

    @Override
    public Member save(Member member){
//        total_id++;
//        member.setId(total_id);
        memberDB.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        for(Member m : memberDB){
            if(m.getId() == id){
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

}
