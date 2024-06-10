package com.tobeto.blog.service.dtos.responses.comment;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentResponse {
    private Integer id;

    private String content;

    private LocalDate date;

    private String postTitle;

    private String username;
}
