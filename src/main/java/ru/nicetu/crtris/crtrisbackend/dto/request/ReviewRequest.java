package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ReviewRequest(
        @NotBlank
        @Size(max = 255)
        String name,

        @Size(max = 255)
        String avatar,

        @NotBlank
        @Size(max = 10_000)
        String description,

        @Size(max = 10_000)
        String text,

        @NotBlank
        @Size(max = 256)
        String jobTitle,

        @PositiveOrZero
        Integer position
) {}