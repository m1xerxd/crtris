package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;

@Mapper(componentModel = "spring")
public interface AboutUsMapper {
    AboutUsResponse toResponse(AboutUs aboutUs);
    CompanyValueResponse toResponse (CompanyValue companyValue);
    CompanyValue toEntity (CompanyValueRequest companyValueRequest);
    void update(@MappingTarget CompanyValue entity, CompanyValueRequest req);
}
