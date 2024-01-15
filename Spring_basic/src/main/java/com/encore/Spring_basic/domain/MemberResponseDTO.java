package com.encore.Spring_basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResponseDTO {
    // 엔티티와 분리시키기 위함
    private long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime create_at;
}
