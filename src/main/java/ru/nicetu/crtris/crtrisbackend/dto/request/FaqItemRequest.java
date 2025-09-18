package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record FaqItemRequest(
        @NotBlank
        @Size(max = 255)
        String question,

        @Size(max = 10_000)
        String answer,

        @PositiveOrZero
        Integer position
) {}