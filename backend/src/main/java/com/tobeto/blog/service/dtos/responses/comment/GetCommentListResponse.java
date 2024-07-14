package com.tobeto.blog.service.dtos.responses.comment;

import com.tobeto.blog.service.dtos.responses.post.GetPostResponse;
import com.tobeto.blog.service.dtos.responses.user.GetUserResponse;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
public class GetCommentListResponse{
    private Integer id;

    private String content;

    private LocalDate date;

    private GetPostResponse post;

    private GetUserResponse user;
}
