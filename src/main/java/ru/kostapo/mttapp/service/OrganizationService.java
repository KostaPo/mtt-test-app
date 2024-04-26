package ru.kostapo.mttapp.service;

import ru.kostapo.mttapp.entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {
    void saveAll(List<Organization> organizations);
    Optional<List<Organization>> getAll();
    Optional<List<Organization>> getAllByKey(String key);
    Optional<Organization> getById(Long id);

}
