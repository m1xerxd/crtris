package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;

@Mapper(componentModel = "spring")
public interface AboutUsMapper {

    AboutUsResponse toResponse(AboutUs aboutUs);
    void update(@MappingTarget AboutUs aboutUs,
                AboutUsUpdateRequest request);

    CompanyValueResponse toResponse(CompanyValue value);
    CompanyValue toEntity(CompanyValueRequest request);
    void update(@MappingTarget CompanyValue value,
                CompanyValueRequest request);
}