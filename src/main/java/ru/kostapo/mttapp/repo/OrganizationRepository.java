package ru.kostapo.mttapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostapo.mttapp.entity.Organization;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByFullNameContaining(String key);
}
