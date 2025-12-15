package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;

@Mapper(config = MapStructConfig.class)
public interface AboutUsMapper {

    AboutUsResponse toResponse(AboutUs aboutUs);

    CompanyValueResponse toResponse(CompanyValue value);

    CompanyValue toEntity(CompanyValueRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "companyValues", ignore = true)
        // список обновляем вручную в сервисе
    void update(@MappingTarget AboutUs aboutUs, AboutUsUpdateRequest request);
}