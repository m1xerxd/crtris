package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.EducationItem;

import java.util.List;

public interface EducationItemRepository extends JpaRepository<EducationItem, Long> {
    List<EducationItem> findAllByOrderByPositionAsc();
}
