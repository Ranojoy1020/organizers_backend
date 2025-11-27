package com.example.assignment.controller;


import com.example.assignment.dto.OrganizerCreateRequest;
import com.example.assignment.dto.OrganizerSearchResponse;
import com.example.assignment.entity.Organizer;
import com.example.assignment.service.OrganizerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {


    private final OrganizerService service;


    public OrganizerController(OrganizerService service) {
        this.service = service;
    }


    /**
     * Create new organizer
     * Status codes: 201 created, 400 validation errors, 409 conflict if email/phone exists
     */
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody OrganizerCreateRequest req) {
        Organizer created = service.createOrganizer(req);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Organizer o = service.getById(id);
        return ResponseEntity.ok(o);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<OrganizerSearchResponse>> search(
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Page<OrganizerSearchResponse> result = service.search(q, page, size);
        return ResponseEntity.ok(result);
    }
}
