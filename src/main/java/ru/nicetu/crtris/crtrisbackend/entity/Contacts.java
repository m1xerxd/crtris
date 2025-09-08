package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "contacts")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Contacts extends BaseEvent {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "email")
    private String email;
}