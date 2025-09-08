package ru.nicetu.crtris.crtrisbackend.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitRequest {
    private String description;
    private Integer position;
}
