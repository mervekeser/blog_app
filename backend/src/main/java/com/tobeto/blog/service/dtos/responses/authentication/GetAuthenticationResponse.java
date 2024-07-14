package com.tobeto.blog.service.dtos.responses.authentication;

import lombok.*;

@Getter
@Setter
@Builder
public class GetAuthenticationResponse {
    private String token;
}
