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
