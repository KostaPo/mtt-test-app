package ru.kostapo.mttapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostapo.mttapp.dto.OrganizationResponseDTO;
import ru.kostapo.mttapp.entity.Organization;
import ru.kostapo.mttapp.mapper.OrganizationMapper;
import ru.kostapo.mttapp.service.OrganizationService;

import java.util.List;
import java.util.Optional;

@Log4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class OrganizationsController {

    private final OrganizationService organizationService;

    @GetMapping("/organizations")
    public ResponseEntity<?> getAll(@RequestParam(required = false) String key) {
        log.info("GET ALL");
        return ResponseEntity.ok(organizationService.getAll(key));
    }

    @GetMapping("/organizations/{id}")
    public ResponseEntity<?> getDataById(@PathVariable Long id) {
        log.info("GET BY ID");
        return ResponseEntity.ok(organizationService.getById(id));
    }
}
