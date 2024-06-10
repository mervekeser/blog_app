package com.tobeto.blog.service.dtos.responses.admin;

import com.tobeto.blog.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminResponse {
    private int id;
    List<UserRole> userRoles;
}
