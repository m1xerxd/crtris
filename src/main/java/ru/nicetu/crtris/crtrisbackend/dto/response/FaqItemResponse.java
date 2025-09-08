package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FaqItemResponse {
    private Long id;
    private String title;
    private String answer;
    private Integer position;
}
