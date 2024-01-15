package com.encore.Spring_basic.domain;

import lombok.Data;

@Data
public class MemberRequestDTO {
    // 엔티티와 분리시키기 위함
    private String name;
    private String email;
    private String password;
}
