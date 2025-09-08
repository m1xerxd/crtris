package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.MainInfo;

import java.util.List;

public interface MainInfoRepository extends JpaRepository<MainInfo, Long> {
    List<MainInfo> findAllByOrderByPositionAsc();
}
