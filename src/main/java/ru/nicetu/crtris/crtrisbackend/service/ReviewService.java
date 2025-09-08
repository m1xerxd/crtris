package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> findAll();
    ReviewResponse findById(Long id);
    ReviewResponse create(ReviewRequest req);
    ReviewResponse update(Long id, ReviewRequest req);
    void delete(Long id);
}
