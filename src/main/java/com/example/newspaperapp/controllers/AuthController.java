package com.example.newspaperapp.controllers;

import com.example.newspaperapp.dtos.auth.AuthResponse;
import com.example.newspaperapp.dtos.auth.LoginRequest;
import com.example.newspaperapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        // hapi 1: authenticate userin
        var user = service.authenticate(request.getEmail(), request.getPassword());

        // hapi 2: generate jwt token
        var token = service.generateToken(user);

        var authResponse = new AuthResponse(token, 86400L); // 24 hours
        return  ResponseEntity.ok(authResponse);
    }
}
