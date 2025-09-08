package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @OrderBy("position ASC")
    @Builder.Default
    private List<MainInfo> info = new ArrayList<>();
}
