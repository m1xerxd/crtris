package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
