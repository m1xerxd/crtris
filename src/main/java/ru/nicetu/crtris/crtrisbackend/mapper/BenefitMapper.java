package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Benefit;

@Mapper(config = MapStructConfig.class)
public interface BenefitMapper {
    Benefit toEntity(BenefitRequest req);

    BenefitResponse toResponse(Benefit e);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(@MappingTarget Benefit target, BenefitRequest source);
}
