package ru.nicetu.crtris.crtrisbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nicetu.crtris.crtrisbackend.entity.Contacts;

import java.util.Optional;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    Optional<Contacts> findTopByOrderByIdAsc();
}
