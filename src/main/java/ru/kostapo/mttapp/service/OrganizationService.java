package ru.kostapo.mttapp.service;

import ru.kostapo.mttapp.dto.OrganizationResponseDTO;
import ru.kostapo.mttapp.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {
    void saveAll(List<Organization> organizations);
    List<OrganizationResponseDTO> getAll(String key);
    OrganizationResponseDTO getById(Long id);

}
