package com.example.assignment.util;


import com.example.assignment.entity.Organizer;
import com.example.assignment.repository.OrganizerRepository;
import org.springframework.stereotype.Component;


@Component
public class OrganizerCodeGenerator {


    private final OrganizerRepository repository;


    public OrganizerCodeGenerator(OrganizerRepository repository) {
        this.repository = repository;
    }


    // Simple synchronized generator using last id to form ORG00001 style codes.
// Not fully safe for distributed systems, but fine for an assignment/demo.
    public synchronized String generate() {
        Organizer last = repository.findTopByOrderByIdDesc();
        long next = 1L;
        if (last != null && last.getId() != null) next = last.getId() + 1;
        return String.format("ORG%05d", next);
    }
}
