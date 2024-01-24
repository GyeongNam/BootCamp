package com.encore.board.post.dto;

import lombok.Data;

@Data
public class PostListDto {
    private Long id;
    private String title;
    private String author_email;
}
