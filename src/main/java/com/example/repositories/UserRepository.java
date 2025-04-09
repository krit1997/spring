package com.example.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
