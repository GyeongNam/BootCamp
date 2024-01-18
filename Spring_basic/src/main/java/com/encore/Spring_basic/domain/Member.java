package com.encore.Spring_basic.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
@NoArgsConstructor
public class Member {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String name;
    @Column(nullable = false, length = 50)
    @Setter
    private String email;
    @Setter
    private String password;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime create_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime update_at;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
