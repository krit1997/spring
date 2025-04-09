package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.User;
import com.example.dto.UserDto;
import com.example.repositories.UserRepository;

@Service
// @RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> sayHello() {
        List<User> data = userRepository.findAll();
        System.out.println(data);
        return data;
    }

    public User create(UserDto userDto) {
        User data = new User();

        data.setName(userDto.getName());

        return userRepository.save(data);
    }
}
