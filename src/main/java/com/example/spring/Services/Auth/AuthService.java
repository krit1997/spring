package com.example.spring.Services.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring.Databases.User;
import com.example.spring.Dto.Auth.Register;
import com.example.spring.Repositories.Users.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User register(Register register) {
        try {
            String password = register.getPassword();
            String passwordConfirm = register.getPasswordConfirm();
            User data = new User();
            if (!password.equals(passwordConfirm)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password and confirmation do not match.");
            }
            data.setEmail(register.getEmail());
            data.setFullName(register.getFullName());
            data.setIsEmailVerified(false);
            data.setPassword(passwordEncoder.encode(register.getPassword()));
            data.setPhoneNumber(register.getPhoneNumber());
            data.setRole(register.getRole());
            data.setStatus(true);
            data.setUsername(register.getEmail().split("@")[0]);

            return userRepository.save(data);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }

    }
}
