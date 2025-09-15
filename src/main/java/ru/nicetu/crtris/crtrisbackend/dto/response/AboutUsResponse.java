package ru.nicetu.crtris.crtrisbackend.dto.response;

import java.util.List;

public record AboutUsResponse(
        String description,
        List<CompanyValueResponse> companyValues
) {}