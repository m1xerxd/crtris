package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EducationItemResponse {
    private Long id;
    private String title;
    private String description;
    private Integer position;
}
