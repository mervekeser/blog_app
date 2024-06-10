package com.tobeto.blog.service.dtos.responses.user;

import java.util.List;
import com.tobeto.blog.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {
    private int id;

    private String name;

    private String surname;

    private String email;

    private List<UserRole> authorities;
}
