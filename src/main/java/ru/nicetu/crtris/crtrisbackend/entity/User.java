package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.nicetu.crtris.crtrisbackend.entity.auth.Role;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEvent {
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean enabled;
}
