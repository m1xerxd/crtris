package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AboutUsResponse {
    private String description;
    private List<CompanyValueResponse> companyValues;
}