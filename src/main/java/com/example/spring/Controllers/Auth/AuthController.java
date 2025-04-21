package com.example.spring.Controllers.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Databases.User;
import com.example.spring.Dto.Auth.Register;
import com.example.spring.Services.Auth.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping()
    public User register(@RequestBody Register register) {
        return authService.register(register);
    }

    @GetMapping()
    public String getList() {
        return "success";
    }

    @GetMapping("/user/{id}")
    public String getDetail(@PathVariable String id) {
        return id;
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @RequestBody String entity) {
        return "update success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return id;
    }
}
