package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "benefit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Benefit extends BaseEvent{

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "position")
    private Integer position;
}
