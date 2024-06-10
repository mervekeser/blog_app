package com.tobeto.blog.service.abstracts;

import com.tobeto.blog.service.dtos.requests.authentication.AddAuthenticationRequest;
import com.tobeto.blog.service.dtos.requests.user.AddUserRequest;
import com.tobeto.blog.service.dtos.responses.authentication.GetAuthenticationResponse;

public interface AuthService {
    GetAuthenticationResponse register(AddUserRequest request);
    GetAuthenticationResponse authenticate(AddAuthenticationRequest request);
}
