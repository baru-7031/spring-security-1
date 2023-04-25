package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getById")
    public Object getById() {
        Object get = restTemplate.getForObject("https://35.223.101.95:8443/v1.0.0/registration/admin/login?objectType=admin&adminId=A002", Object.class);
        return get;
    }

}
