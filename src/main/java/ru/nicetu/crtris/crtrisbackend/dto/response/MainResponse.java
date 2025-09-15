package ru.nicetu.crtris.crtrisbackend.dto.response;

import java.util.List;

public record MainResponse(
        String description,
        List<MainInfoResponse> info
) {}