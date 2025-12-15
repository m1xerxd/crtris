package ru.nicetu.crtris.crtrisbackend.dto.response;

public record BenefitResponse(
        Long id,
        String description,
        Integer position
) {
}