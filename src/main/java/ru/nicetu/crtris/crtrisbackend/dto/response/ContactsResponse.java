package ru.nicetu.crtris.crtrisbackend.dto.response;

public record ContactsResponse(
        String phoneNumber,
        String telegram,
        String email
) {
}