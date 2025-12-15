package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.entity.FaqItem;

@Mapper(config = MapStructConfig.class)
public interface FaqMapper {
    FaqItem toEntity(FaqItemRequest req);

    FaqItemResponse toResponse(FaqItem e);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(@MappingTarget FaqItem target, FaqItemRequest source);
}
