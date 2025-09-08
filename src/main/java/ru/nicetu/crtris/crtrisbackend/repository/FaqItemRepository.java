package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.FaqItem;

import java.util.List;

public interface FaqItemRepository extends JpaRepository<FaqItem, Long> {
    List<FaqItem> findAllByOrderByPositionAsc();
}
