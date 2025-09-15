package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);
}
