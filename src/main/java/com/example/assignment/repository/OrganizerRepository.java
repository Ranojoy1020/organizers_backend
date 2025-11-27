package com.example.assignment.repository;

import com.example.assignment.entity.Organizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface OrganizerRepository extends JpaRepository<Organizer, Long> {


    Optional<Organizer> findByEmail(String email);
    Optional<Organizer> findByPhone(String phone);


    @Query("SELECT o FROM Organizer o WHERE " +
            "LOWER(o.name) LIKE LOWER(CONCAT('%', :q, '%')) OR " +
            "LOWER(o.email) LIKE LOWER(CONCAT('%', :q, '%')) OR " +
            "LOWER(o.phone) LIKE LOWER(CONCAT('%', :q, '%'))")
    Page<Organizer> searchByNameEmailPhone(@Param("q") String q, Pageable pageable);


    Organizer findTopByOrderByIdDesc();
}
