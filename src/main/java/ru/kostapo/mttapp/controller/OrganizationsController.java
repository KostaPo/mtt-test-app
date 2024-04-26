package ru.kostapo.mttapp.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostapo.mttapp.entity.Organization;
import ru.kostapo.mttapp.mapper.OrganizationMapper;
import ru.kostapo.mttapp.service.OrganizationService;

import java.util.List;
import java.util.Optional;

@Log4j
@RestController
@RequestMapping("/app")
public class OrganizationsController {

    private final OrganizationService organizationService;

    public OrganizationsController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@RequestParam(required = false) String key) {
        Optional<List<Organization>> organizations = (key != null)
                ? organizationService.getAllByKey(key)
                : organizationService.getAll();
        if (organizations.isPresent()) {
            return ResponseEntity
                    .ok(OrganizationMapper.INSTANCE.organizationsToOrganizationResponseDTOs(organizations.get()));
        } else {
            return ResponseEntity.ok("список пуст");
        }
    }

    @RequestMapping(value = "/organizations/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDataById(@PathVariable Long id) {
        Optional<Organization> organization = organizationService.getById(id);
        if (organization.isPresent()) {
            return ResponseEntity
                    .ok(OrganizationMapper.INSTANCE.organizationToOrganizationResponseDTO(organization.get()));
        } else {
            return ResponseEntity.ok("организация не найдена");
        }
    }
}
