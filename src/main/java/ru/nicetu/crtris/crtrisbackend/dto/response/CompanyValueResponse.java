package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyValueResponse {
    private Long id;
    private String title;
    private Integer position;
}