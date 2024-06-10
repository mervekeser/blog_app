package com.tobeto.blog.service.dtos.requests.user;

import com.tobeto.blog.enums.UserRole;
import com.tobeto.blog.service.constants.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private int id;

    @NotNull(message = Messages.UserMessage.USER_NAME_NOT_BLANK)
    @Pattern(regexp = Messages.UserMessage.USER_ONLY_LETTERS_REGEX, message = Messages.UserMessage.USER_NAME_ONLY_LETTERS)
    private String name;

    @NotNull(message = Messages.UserMessage.USER_SURNAME_NOT_BLANK)
    @Pattern(regexp = Messages.UserMessage.USER_ONLY_LETTERS_REGEX, message = Messages.UserMessage.USER_SURNAME_ONLY_LETTERS)
    private String surname;

    @Email(message = Messages.UserMessage.ENTER_VALID_EMAIL)
    private String email;

    private String password;

    private List<UserRole> authorities;
}
