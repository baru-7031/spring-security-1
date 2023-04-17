package com.example.demo.service;

import com.example.demo.entity.AuthUser;
import com.example.demo.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public AuthUser create(AuthUser user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public String login() {
        return "Login Completed";
    }
}
