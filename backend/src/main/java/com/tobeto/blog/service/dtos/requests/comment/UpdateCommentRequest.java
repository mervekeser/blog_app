package com.tobeto.blog.service.dtos.requests.comment;

import com.tobeto.blog.service.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentRequest implements CommentRequest{
    @NotNull(message = Messages.IdMessages.ID_NOT_NULL)
    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer id;

    @NotBlank(message = Messages.CommentMessages.CONTENT_NOT_BLANK)
    private String content;

    private LocalDate date;

    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer postId;

    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private Integer userId;

    @Override
    public String getContent() {
        return content;
    }
}
