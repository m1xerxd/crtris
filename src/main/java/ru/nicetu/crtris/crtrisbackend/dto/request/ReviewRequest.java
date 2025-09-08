package ru.nicetu.crtris.crtrisbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String name;
    private String description;
    private String text;
    private Integer position;
}
