package ru.nicetu.crtris.crtrisbackend.dto.request;

public record EducationItemRequest(
        String title,
        String description,
        Integer position
) {}