package ru.nicetu.crtris.crtrisbackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

@Schema(name = "ReviewRequest")
public record ReviewRequest(
        @NotBlank
        @Size(max = 255)
        String name,

        @NotBlank
        @Size(max = 10_000)
        String description,

        @Size(max = 10_000)
        String text,

        @NotBlank
        @Size(max = 256)
        String jobTitle,

        @PositiveOrZero
        Integer position
) {
}