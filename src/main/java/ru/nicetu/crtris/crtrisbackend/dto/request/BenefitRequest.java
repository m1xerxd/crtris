package ru.nicetu.crtris.crtrisbackend.dto.request;

public record BenefitRequest(
        String description,
        Integer position
) {}