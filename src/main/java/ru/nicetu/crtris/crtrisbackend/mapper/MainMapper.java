package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.entity.Main;
import ru.nicetu.crtris.crtrisbackend.entity.MainInfo;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;

@Mapper(componentModel = "spring")
public interface MainMapper {
    MainResponse toResponse(Main main);
    void update(@MappingTarget Main entity, MainUpdateRequest request);

    MainInfoResponse toResponse(MainInfo info);
    MainInfo toEntity(MainInfoRequest request);
    void update(@MappingTarget MainInfo entity, MainInfoRequest request);
}