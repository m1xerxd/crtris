package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "main_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainInfo extends BaseEvent {

    @Column(nullable = false)
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "position")
    private Integer position;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "main_id")
    private Main main;
}
