package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.Main;

import java.util.Optional;

public interface MainRepository extends JpaRepository<Main, Long> {
    Optional<Main> findTopByOrderByIdAsc();
}
