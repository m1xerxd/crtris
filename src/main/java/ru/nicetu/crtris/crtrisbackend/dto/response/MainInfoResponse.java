package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MainInfoResponse {
    private Long id;
    private String name;
    private String value;
    private Integer position;
}
