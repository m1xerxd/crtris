package ru.nicetu.crtris.crtrisbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutUsUpdateRequest {
    private String description;
}
