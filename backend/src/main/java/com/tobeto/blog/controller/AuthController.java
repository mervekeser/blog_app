package com.tobeto.blog.controller;

import com.tobeto.blog.service.abstracts.AuthService;
import com.tobeto.blog.service.dtos.requests.authentication.AddAuthenticationRequest;
import com.tobeto.blog.service.dtos.requests.user.AddUserRequest;
import com.tobeto.blog.service.dtos.responses.authentication.GetAuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
@CrossOrigin
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<GetAuthenticationResponse> register(
            @RequestBody AddUserRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }



    @PostMapping("/authenticate")
    public ResponseEntity<GetAuthenticationResponse> authenticate(
            @RequestBody AddAuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
