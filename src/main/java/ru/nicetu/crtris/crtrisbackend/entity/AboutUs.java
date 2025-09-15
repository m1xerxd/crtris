package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "about_us")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutUs extends BaseEvent{

    @Column
    private String description;

    @OneToMany(mappedBy = "aboutUs", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC")
    private List<CompanyValue> companyValues = new ArrayList<>();
}
