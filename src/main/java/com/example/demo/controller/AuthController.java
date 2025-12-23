package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User request) {
        // Normally you would validate user credentials here
        User user = request; // For demo, we assume the request contains valid user info

        // Generate token
        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getRole()
        );

        AuthResponse response = new AuthResponse();
        response.setUsername(user.getUsername());
        response.setUserId(user.getId());
        response.setRole(user.getRole());
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}
