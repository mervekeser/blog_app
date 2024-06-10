package com.tobeto.blog.service.dtos.requests.admin;

import com.tobeto.blog.service.constants.Messages;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAdminRequest {
    @Positive(message = Messages.IdMessages.ID_NOT_NEGATIVE)
    private int userId;

}
