package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Main;
import ru.nicetu.crtris.crtrisbackend.entity.MainInfo;

@Mapper(config = MapStructConfig.class)
public interface MainMapper {

    MainResponse toMainResponse(Main main);
    MainInfoResponse toMainInfoResponse(MainInfo info);

    MainInfo toEntity(MainInfoRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(@MappingTarget Main entity, MainUpdateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(@MappingTarget MainInfo entity, MainInfoRequest request);
}
