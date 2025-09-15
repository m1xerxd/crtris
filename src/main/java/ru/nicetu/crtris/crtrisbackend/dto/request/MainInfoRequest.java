package ru.nicetu.crtris.crtrisbackend.dto.request;

public record MainInfoRequest(
        String name,
        String value,
        Integer position
) {}