package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        AuthResponse res = new AuthResponse();
        res.setToken("dummy-token");
        res.setEmail(request.getEmail());
        res.setRole("ADMIN");
        res.setUserId(1L);
        return res;
    }
}
