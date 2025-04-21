package com.example.spring.Dto.Auth;

import lombok.Data;

@Data
public class Register {
    private String email;
    private String password;
    private String passwordConfirm;
    private String fullName;
    private String phoneNumber;
    private String role;
}
