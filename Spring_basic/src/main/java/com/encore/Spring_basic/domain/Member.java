package com.encore.Spring_basic.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Member {
    private long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime create_at;

//    public Member(String name, String email, String password) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.localDateTime = localDateTime;
//    }
}
