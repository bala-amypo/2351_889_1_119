package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtUtil;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User request) {
        // Here we simulate authentication
        // In real scenario, you would verify password with UserService/UserRepository
        String email = request.getEmail(); // use getEmail() instead of getUsername()

        // Simulate fetching user from DB (replace with actual UserService call)
        User user = new User(email, "password", "ROLE_USER");

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail(), user.getId(), user.getRole());

        // Return AuthResponse
        AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }
}
