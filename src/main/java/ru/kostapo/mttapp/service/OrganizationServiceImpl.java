package ru.kostapo.mttapp.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kostapo.mttapp.dto.OrganizationResponseDTO;
import ru.kostapo.mttapp.entity.Organization;
import ru.kostapo.mttapp.mapper.OrganizationMapper;
import ru.kostapo.mttapp.repo.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Log4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public void saveAll(List<Organization> organizations) {
        organizationRepository.saveAll(organizations);
    }

    @Override
    public List<OrganizationResponseDTO> getAll(String key) {
        Optional<List<Organization>> organizations = (key != null && !key.isEmpty())
                ? Optional.of(organizationRepository.findByFullNameContaining(key))
                : Optional.of(organizationRepository.findAll());
        if (organizations.isPresent() && !organizations.get().isEmpty()) {
            log.info("found!");
            return OrganizationMapper.INSTANCE.organizationsToOrganizationResponseDTOs(organizations.get());
        } else {
            log.info("not found!");
            throw new EntityNotFoundException("Организации не найдены");
        }
    }

    @Override
    public OrganizationResponseDTO getById(Long id) {
        log.info("id for search: " + id);
        Optional<Organization> organization = organizationRepository.findById(id);
        if(organization.isPresent()) {
            log.info("found!");
            return OrganizationMapper.INSTANCE.organizationToOrganizationResponseDTO(organization.get());
        } else {
            log.info("not found!");
            throw new EntityNotFoundException("Организация не найдена по id: " + id);
        }
    }
}
