package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDetails {

    @JsonProperty("ResourceType")
    private String resourceType;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String contactnumber;
    private String email;
    private String pincode;
    private Notification notification;
    private String objectType;
    private String appoitmentId;
    private String password;
    private List<String> role;
    private Integer loginLimitor;
    private Boolean active;
    private Boolean status;
    private String imageURL;
    private String uuid;

}




