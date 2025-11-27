package com.example.assignment.dto;

public class OrganizerSearchResponse {
    private Long id;
    private String organizerCode;
    private String name;
    private String email;
    private String phone;


    public OrganizerSearchResponse() {}


    public OrganizerSearchResponse(Long id, String organizerCode, String name, String email, String phone) {
        this.id = id;
        this.organizerCode = organizerCode;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public String getOrganizerCode() { return organizerCode; }
    public void setOrganizerCode(String organizerCode) { this.organizerCode = organizerCode; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
