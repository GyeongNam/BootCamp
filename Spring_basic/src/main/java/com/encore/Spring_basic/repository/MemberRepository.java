package com.encore.Spring_basic.repository;

import com.encore.Spring_basic.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public List<Member> findAll();
    public Member save(Member member);

    public Optional<Member> findById(long id);
}
