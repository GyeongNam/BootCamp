package com.encore.board.author.repository;

import com.encore.board.author.domain.Author;
import com.encore.board.author.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
@DataJpaTest 를 사용하면 매 테스트가 종료되면 자동으로 DB 원상복구
모든 스프링 빈을 생성하지는 않고 DB 테스트 특화 어노테이션이다.
@SpringBootTest 는 자동 롤백 기능은 지원하지 않고, 별도로 롤백 코드가 필요.
실제 스프링 실행과 동일하게 스프링 빈 생성 및 주입
 */
//@DataJpaTest
@SpringBootTest
//@Transactional
/*
replace = AutoConfigureTestDatabase.Replace.ANY : H2 db(spring 내장)
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public  void  authorSaveTest(){
        // 준비 단계 (prepare, given)
        Author author = Author.builder()
                .name("박세종")
                .email("세종3@한화")
                .password("1234")
                .role(Role.USER)
                .build();

        // 실행 단계 (execute, when)
        authorRepository.save(author);
        Author authorDB = authorRepository.findByEmail("세종3@한화").orElse(null);

        // 검증 단계 (then)
        assertEquals(author.getEmail(), authorDB.getEmail());
    }

}
