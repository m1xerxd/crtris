package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyValueRequest(
        @NotBlank
        String title,

        @NotNull
        Integer position
) {
}