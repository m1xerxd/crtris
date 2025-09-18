package ru.nicetu.crtris.crtrisbackend.dto.response;

public record CompanyValueResponse(
        Long id,
        String title,
        Integer position
) {}