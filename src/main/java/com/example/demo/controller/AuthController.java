package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

   
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

     
        User user = authService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

    
        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getRole()
        );

       
        AuthResponse response = new AuthResponse(
                token,
                user.getId(),
                user.getUsername(),
                user.getRole()
        );

       
        return ResponseEntity.ok(response);
    }
}
