package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.Main;

import java.util.Optional;

public interface AboutUsRepository extends JpaRepository<AboutUs, Long> {
    Optional<AboutUs> findTopByOrderByIdAsc();
}
