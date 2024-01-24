package com.encore.board.author.repository;

import com.encore.board.author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    // findBy 컬럼명의 규칙으로 자동으로 where조건문을 사용한 메서드 생성
    Optional<Author> findByEmail(String email);
}
