package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;
import ru.nicetu.crtris.crtrisbackend.entity.EducationItem;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    EducationItem toEntity(EducationItemRequest educationItemRequest);
    EducationItemResponse toResponse(EducationItem educationItem);
    void update(@MappingTarget EducationItem educationItem, EducationItemRequest educationItemRequest);
}
