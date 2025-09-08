package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewRequest reviewRequest);
    ReviewResponse toResponse(Review review);
    void update(@MappingTarget Review review, ReviewRequest reviewRequest);
}
