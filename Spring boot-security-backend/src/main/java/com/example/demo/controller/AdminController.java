package com.example.demo.controller;

import com.example.demo.entity.AdminDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getById/")
    public AdminDetails getById(@RequestParam String objectType, @RequestParam String adminId) {
        log.info("getById(String,String) -> | ObjectType : {} | AdminId : {}",objectType,adminId);
        AdminDetails get = restTemplate
                .getForObject("https://35.223.101.95:8443/v1.0.0/registration/admin/login?objectType="+objectType+"&adminId="+adminId, AdminDetails.class);
        log.info("getById(String,String) -> | AdminDetails : {}",get);
        return get;
    }

    @PostMapping("/create")
    public AdminDetails create(@RequestBody AdminDetails adminDetails) {
        log.info("create(AdminDetails) -> | AdminDetails : {}",adminDetails);
        AdminDetails get = restTemplate
                .postForObject("https://35.223.101.95:8443/v1.0.0/registration/admin/register", adminDetails, AdminDetails.class);
        log.info("create(AdminDetails) -> | Return AdminDetails : {}",adminDetails);
        return get;
    }

}





