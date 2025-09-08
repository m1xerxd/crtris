package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Benefit;

@Mapper(componentModel = "spring")
public interface BenefitMapper {
    Benefit toEntity(BenefitRequest benefitRequest);
    BenefitResponse toResponse(Benefit benefit);
    void update(@MappingTarget Benefit benefit, BenefitRequest benefitRequest);
}
