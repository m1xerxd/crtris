package ru.nicetu.crtris.crtrisbackend.dto.response;

public record EducationItemResponse(
        Long id,
        String title,
        String description,
        Integer position
) {}