package com.tobeto.blog.service.dtos.requests.post;

import com.tobeto.blog.service.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class AddPostRequest {
    @NotBlank(message = Messages.PostMessages.TITLE_NOT_BLANK)
    private String title;

    @NotBlank(message = Messages.PostMessages.CONTENT_NOT_BLANK)
    private String content;

    private LocalDate publicationDate;

    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer userId;
}
