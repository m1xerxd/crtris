package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.entity.FaqItem;

@Mapper(componentModel = "spring")
public interface FaqMapper {
    FaqItem toEntity(FaqItemRequest faqItemRequest);
    FaqItemResponse toResponse(FaqItem faqItem);
    void update(@MappingTarget FaqItem faqItem, FaqItemRequest faqItemRequest);
}
