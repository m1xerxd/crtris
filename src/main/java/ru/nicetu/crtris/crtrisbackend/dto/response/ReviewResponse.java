package ru.nicetu.crtris.crtrisbackend.dto.response;

public record ReviewResponse(
        Long id,
        String name,
        String avatar,
        String description,
        String text,
        String jobTitle,
        Integer position
) {}