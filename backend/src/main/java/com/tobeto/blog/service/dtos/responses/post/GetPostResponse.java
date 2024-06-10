package com.tobeto.blog.service.dtos.responses.post;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPostResponse{
    private Integer id;

    private String title;

    private String content;

    private LocalDate publicationDate;

    private String username;
}
