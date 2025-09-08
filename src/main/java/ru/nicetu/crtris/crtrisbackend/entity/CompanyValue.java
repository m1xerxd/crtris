package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_value")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyValue extends BaseEvent{

    @Column(nullable = false)
    private String title;

    @Column(name = "position")
    private Integer position;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "about_id")
    private AboutUs aboutUs;
}
