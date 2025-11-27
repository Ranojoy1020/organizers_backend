package com.example.assignment.entity;

import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "organizers", indexes = {
        @Index(name = "idx_name", columnList = "name"),
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_phone", columnList = "phone")
})
public class Organizer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    private String organizerCode;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false, unique = true)
    private String phone;


    private String businessType;


    @Column(nullable = false)
    private String status; // ACTIVE / INACTIVE


    private Instant createdAt;
    private Instant updatedAt;


    // Constructors
    public Organizer() {}


    // Getters and setters
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


    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }


    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }


    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
