package com.tobeto.blog.service.dtos.requests.authentication;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthenticationRequest {
    private String email;
    String password;
}
