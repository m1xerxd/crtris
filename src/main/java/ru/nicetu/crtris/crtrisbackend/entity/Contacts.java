package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contacts extends BaseEvent {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "email")
    private String email;
}