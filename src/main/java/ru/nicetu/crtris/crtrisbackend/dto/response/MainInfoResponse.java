package ru.nicetu.crtris.crtrisbackend.dto.response;

public record MainInfoResponse(
        Long id,
        String name,
        String value,
        Integer position
) {}