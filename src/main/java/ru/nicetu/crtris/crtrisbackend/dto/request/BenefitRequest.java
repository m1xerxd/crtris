package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record BenefitRequest(
        @NotBlank
        @Size(max = 10_000)
        String description,

        @PositiveOrZero
        Integer position
) {
}