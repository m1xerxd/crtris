package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record MainInfoRequest(
        @NotBlank
        @Size(max = 255)
        String name,

        @Size(max = 255)
        String value,

        @PositiveOrZero
        Integer position
) {
}