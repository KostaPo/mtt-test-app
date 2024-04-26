package ru.kostapo.mttapp.service;

import org.springframework.stereotype.Service;
import ru.kostapo.mttapp.entity.Organization;
import ru.kostapo.mttapp.repo.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void saveAll(List<Organization> organizations) {
        organizationRepository.saveAll(organizations);
    }

    @Override
    public Optional<List<Organization>> getAll() {
        return Optional.of(organizationRepository.findAll());
    }

    @Override
    public Optional<List<Organization>> getAllByKey(String key) {
        return Optional.of(organizationRepository.findByFullNameContaining(key));
    }

    @Override
    public Optional<Organization> getById(Long id) {
        return organizationRepository.findById(id);
    }
}
