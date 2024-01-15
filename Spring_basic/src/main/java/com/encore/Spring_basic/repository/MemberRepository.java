package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;

import java.util.List;

public interface MemberRepository {
    public List<Member> members();
    public void memberCreate(Member member);

    public Member memberFindById(long id);
}
