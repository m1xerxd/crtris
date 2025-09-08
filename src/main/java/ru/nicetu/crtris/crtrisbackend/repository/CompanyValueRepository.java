package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;

import java.util.List;

public interface CompanyValueRepository extends JpaRepository<CompanyValue, Long> {
    List<CompanyValue> findAllByOrderByPositionAsc();
}
