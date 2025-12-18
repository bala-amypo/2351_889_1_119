package com.example.demo.model;
import jakarta.persistence.*;
public class User{
    @Id
    private Long id;
    private String FullName;
    @Email(message="invalid")
    @column(unique=true)
    private String email;
    private String password;
    private localdate createdAt;

}
