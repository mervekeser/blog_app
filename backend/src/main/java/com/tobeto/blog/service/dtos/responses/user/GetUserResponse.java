package com.tobeto.blog.service.dtos.responses.user;

import java.util.List;
import com.tobeto.blog.enums.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {
    private int id;

    private String name;

    private String surname;

    private String email;

    private List<UserRole> authorities;
}
