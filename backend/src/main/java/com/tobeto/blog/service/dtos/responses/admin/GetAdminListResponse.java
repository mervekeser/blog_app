package com.tobeto.blog.service.dtos.responses.admin;

import com.tobeto.blog.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAdminListResponse {
    private int id;
    List<UserRole> userRoles;
}
