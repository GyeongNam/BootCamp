package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements  MemberRepository{
    private List<Member> memberDB = new ArrayList<>();

    @Override
    public List<Member> members(){
        return this.memberDB;
    }

    @Override
    public void memberCreate(Member member){
        memberDB.add(member);
    }

    @Override
    public Member memberFindById(long id) {
        Member member = null;
        for(Member m : memberDB){
            if(m.getId() == id){
                return m;
            }
        }
        return member;
    }

}
