package com.encore.board.author.dto;

import lombok.Data;

@Data
public class AuthorUpdateDto {
    private Long id;
    private String name;
    private String password;
}
