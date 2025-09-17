package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
}
