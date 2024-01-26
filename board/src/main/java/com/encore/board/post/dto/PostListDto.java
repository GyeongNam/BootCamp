package com.encore.board.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListDto {
    private Long id;
    private String title;
    private String author_email;
    private String appointment;
    private LocalDateTime appointmentTime;
}
