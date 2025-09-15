package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MainResponse {
    private String description;
    private List<MainInfoResponse> info;
}