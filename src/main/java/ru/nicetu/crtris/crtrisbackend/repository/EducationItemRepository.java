package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.EducationItem;

public interface EducationItemRepository extends JpaRepository<EducationItem, Long> {
}
