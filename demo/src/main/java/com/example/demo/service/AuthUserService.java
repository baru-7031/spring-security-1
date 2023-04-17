package com.example.demo.service;


import com.example.demo.entity.AuthUser;

public interface AuthUserService {

    AuthUser create(AuthUser user);
    String login();
}
