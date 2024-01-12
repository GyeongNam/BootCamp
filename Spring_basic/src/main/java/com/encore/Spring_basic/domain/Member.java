package com.encore.Spring_basic.domain;

import lombok.*;

@Data
@Getter
@Setter
public class Member {
    private String name;
    private String email;
    private String password;
}
