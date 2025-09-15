package ru.nicetu.crtris.crtrisbackend.dto.response;

public record CurrentUserResponse(
        String username,
        String role
) {}