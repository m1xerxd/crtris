package ru.nicetu.crtris.crtrisbackend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ContactsRequest(
        @Size(max = 100)
        String phoneNumber,

        @Size(max = 64)
        String telegram,

        @Email
        @Size(max = 255)
        String email
) {}