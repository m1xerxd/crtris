package ru.nicetu.crtris.crtrisbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MainInfoRequest {
    private String name;
    private String value;
    private Integer position;
}
