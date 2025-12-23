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

    // Example login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User request) {
        // In a real app, validate username/password here
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());

        // Generate token
        String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail());

        AuthResponse response = new AuthResponse(token, user.getId(), user.getUsername(), user.getEmail());
        return ResponseEntity.ok(response);
    }

    // Example registration endpoint
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User request) {
        User newUser = new User(request.getUsername(), request.getEmail(), request.getPassword());
        // In a real app, save newUser to DB here

        String token = jwtUtil.generateToken(newUser.getUsername(), newUser.getId(), newUser.getEmail());
        AuthResponse response = new AuthResponse(token, newUser.getId(), newUser.getUsername(), newUser.getEmail());
        return ResponseEntity.ok(response);
    }
}
