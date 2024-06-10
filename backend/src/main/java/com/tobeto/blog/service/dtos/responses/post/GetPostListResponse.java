package com.tobeto.blog.service.dtos.responses.post;

import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPostListResponse {
    private Integer id;

    private String title;

    private String content;

    private LocalDate publicationDate;

    private GetUserResponse user;
}
