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
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseEvent{

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "text", columnDefinition = "text", nullable = false)
    private String text;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "position")
    private Integer position;
}
