package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String name;
    private String description;
    private String text;
    private Integer position;
}
