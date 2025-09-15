package ru.nicetu.crtris.crtrisbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "faq_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqItem extends BaseEvent{

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", columnDefinition = "text")
    private String answer;

    @Column(name = "position")
    private Integer position;
}
