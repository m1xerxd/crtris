package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.Size;

public record MainUpdateRequest(
        @Size(max = 10_000)
        String description
) {}