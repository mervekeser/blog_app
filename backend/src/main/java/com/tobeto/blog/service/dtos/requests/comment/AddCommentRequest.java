package com.tobeto.blog.service.dtos.requests.comment;

import com.tobeto.blog.service.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class AddCommentRequest {

    @NotBlank(message = Messages.CommentMessages.CONTENT_NOT_BLANK)
    private String content;

    private LocalDate date;

    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer postId;

    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer userId;


}
