package com.example.jpa.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
}
