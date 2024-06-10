package com.tobeto.blog.service.dtos.responses.authentication;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthenticationResponse {
    private String token;
}
