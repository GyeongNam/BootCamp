package com.encore.board.post.dto;

import lombok.Data;

@Data
public class PostCreateDto {
    private String title;
    private String contents;
    private String appointment;
    private String appointmentTime;
}
