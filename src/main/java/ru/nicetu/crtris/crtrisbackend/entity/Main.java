package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "main")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Main extends BaseEvent{

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "main", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MainInfo> info = new ArrayList<>();
}
