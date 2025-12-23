
package com.example.demo.dto;

public class LoginRequest {

    private String username;
    private String password;

    // ✅ Required by Spring (no-args constructor)
    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
