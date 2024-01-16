package com.encore.Spring_basic.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


//@AllArgsConstructor

@Getter
/*
@Entity 를 통해 DB 테이블 및 컬럼을 자동 생성
 */
@Entity
public class Member {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    private String password;
    @Setter

    @Column(name = "created_at")
    private LocalDateTime create_at;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.create_at = LocalDateTime.now();
    }

    public Member() {

    }
}
