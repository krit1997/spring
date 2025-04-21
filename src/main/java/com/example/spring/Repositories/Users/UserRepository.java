package com.example.spring.Repositories.Users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.Databases.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
