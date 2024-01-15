package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;

import java.util.List;

public class MemberJdbcRepository implements MemberRepository {
    @Override
    public List<Member> members() {
        return null;
    }

    @Override
    public void memberCreate(Member member) {

    }

    @Override
    public Member memberFindById(long id) {
        return null;
    }
}
