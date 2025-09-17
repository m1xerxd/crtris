package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AboutUsUpdateRequest(
        String description,

        @NotNull
        @Valid
        List<CompanyValueRequest> companyValues
) {}