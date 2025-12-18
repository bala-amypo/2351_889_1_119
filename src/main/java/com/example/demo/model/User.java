package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
public class User{
    @Id
    private Long id;
    private String FullName;
    @Email(message="invalid")
    @column(unique=true)
    private String email;
    private String password;
    private LocalDateTime createdAt;

}
