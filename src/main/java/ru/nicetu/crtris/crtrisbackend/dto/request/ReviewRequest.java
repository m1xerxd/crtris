package ru.nicetu.crtris.crtrisbackend.dto.request;

public record ReviewRequest(
        String name,
        String description,
        String text,
        Integer position
) {}