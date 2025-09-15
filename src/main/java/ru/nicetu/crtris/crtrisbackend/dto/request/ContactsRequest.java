package ru.nicetu.crtris.crtrisbackend.dto.request;

public record ContactsRequest(
        String phoneNumber,
        String telegram,
        String email
) {}