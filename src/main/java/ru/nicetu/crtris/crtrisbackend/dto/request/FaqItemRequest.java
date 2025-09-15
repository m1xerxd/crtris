package ru.nicetu.crtris.crtrisbackend.dto.request;

public record FaqItemRequest(
        String question,
        String answer,
        Integer position
) {}