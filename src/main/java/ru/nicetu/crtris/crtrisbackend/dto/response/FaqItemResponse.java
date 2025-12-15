package ru.nicetu.crtris.crtrisbackend.dto.response;

public record FaqItemResponse(
        Long id,
        String question,
        String answer,
        Integer position
) {
}