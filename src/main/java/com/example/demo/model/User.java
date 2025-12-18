package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity
@Table(name = "users")

public class User{
    @Id
    private Long id;
    private String FullName;
    @Email(message="invalid")
    @Column(unique=true)
    private String email;
    private String password;
    private LocalDateTime createdAt;
    public User(Long id, String fullName, String email, String password, LocalDateTime createdAt) {
        this.id = id;
        FullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
