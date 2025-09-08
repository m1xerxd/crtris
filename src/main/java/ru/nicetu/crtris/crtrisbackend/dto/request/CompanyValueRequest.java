package ru.nicetu.crtris.crtrisbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyValueRequest {
    private String title;
    private Integer position;
}
