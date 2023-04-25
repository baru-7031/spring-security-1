package com.example.demo.repository;

import com.example.demo.entity.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthUserRepository extends MongoRepository<AuthUser, String> {

    Optional<AuthUser> findByUsername(String username);

}
