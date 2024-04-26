package ru.kostapo.mttapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostapo.mttapp.entity.Director;
import ru.kostapo.mttapp.entity.Organization;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
