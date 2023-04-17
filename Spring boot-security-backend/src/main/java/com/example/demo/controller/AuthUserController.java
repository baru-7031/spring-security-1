package com.example.demo.controller;

import com.example.demo.entity.AuthUser;
import com.example.demo.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthUserService service;

    @PostMapping("/create")
    public AuthUser create(@RequestBody AuthUser user) {
        return service.create(user);
    }

    @GetMapping("/login")
    public HashMap<String, String> login() {
        String login = service.login();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("message",login);
        return hm;
    }

}
