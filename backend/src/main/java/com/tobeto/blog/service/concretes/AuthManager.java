package com.tobeto.blog.service.concretes;

import com.tobeto.blog.core.services.JwtService;
import com.tobeto.blog.entity.concretes.User;
import com.tobeto.blog.service.abstracts.AuthService;
import com.tobeto.blog.service.abstracts.UserService;
import com.tobeto.blog.service.dtos.requests.authentication.AddAuthenticationRequest;
import com.tobeto.blog.service.dtos.requests.user.AddUserRequest;
import com.tobeto.blog.service.dtos.responses.authentication.GetAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public GetAuthenticationResponse register(AddUserRequest request) {
        var user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(request.getAuthorities())
                .build();
        userService.add(user);
        var jwtToken = jwtService.generateToken(user);
        return GetAuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public GetAuthenticationResponse authenticate(AddAuthenticationRequest request) {
        User userEntity = userService.getByEmail(request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var jwtToken = jwtService.generateToken(userEntity);
        return GetAuthenticationResponse.builder().token(jwtToken).build();
    }
}
