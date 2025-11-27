package com.example.assignment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class OrganizerCreateRequest {


    @NotBlank(message = "Name must not be blank")
    private String name;


    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email")
    private String email;


    @NotBlank(message = "Phone must not be blank")
    @Size(min = 7, max = 20, message = "Phone length must be between 7 and 20")
    private String phone;


    private String businessType;


    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }


    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }
}
