package com.example.assignment.service;
import com.example.assignment.dto.OrganizerCreateRequest;
import com.example.assignment.dto.OrganizerSearchResponse;
import com.example.assignment.entity.Organizer;
import com.example.assignment.exception.ApiError;
import com.example.assignment.repository.OrganizerRepository;
import com.example.assignment.util.OrganizerCodeGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganizerService {


    private final OrganizerRepository repository;
    private final OrganizerCodeGenerator codeGenerator;


    public OrganizerService(OrganizerRepository repository, OrganizerCodeGenerator codeGenerator) {
        this.repository = repository;
        this.codeGenerator = codeGenerator;
    }


    @Transactional
    public Organizer createOrganizer(OrganizerCreateRequest req) {
// validate unique email/phone
        repository.findByEmail(req.getEmail()).ifPresent(o -> {
            throw new ApiError(HttpStatus.CONFLICT, "Email already in use");
        });
        repository.findByPhone(req.getPhone()).ifPresent(o -> {
            throw new ApiError(HttpStatus.CONFLICT, "Phone already in use");
        });


        Organizer org = new Organizer();
        org.setName(req.getName());
        org.setEmail(req.getEmail());
        org.setPhone(req.getPhone());
        org.setBusinessType(req.getBusinessType());
        org.setStatus("ACTIVE");
        org.setCreatedAt(Instant.now());
        org.setUpdatedAt(Instant.now());


// generate code BEFORE save to ensure uniqueness check (uses last id)
        String code = codeGenerator.generate();
        org.setOrganizerCode(code);


        return repository.save(org);
    }


    public Organizer getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ApiError(HttpStatus.NOT_FOUND, "Organizer not found"));
    }


    public Page<OrganizerSearchResponse> search(String q, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Organizer> p = repository.searchByNameEmailPhone(q == null ? "" : q.trim(), pageable);
        List<OrganizerSearchResponse> list = p.getContent().stream()
                .map(o -> new OrganizerSearchResponse(o.getId(), o.getOrganizerCode(), o.getName(), o.getEmail(), o.getPhone()))
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, p.getTotalElements());
    }
}