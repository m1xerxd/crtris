package ru.nicetu.crtris.crtrisbackend.service;

import org.springframework.web.multipart.MultipartFile;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> findAll();

    ReviewResponse findById(Long id);

    ReviewResponse create(ReviewRequest req, MultipartFile avatar);

    ReviewResponse update(Long id, ReviewRequest req, MultipartFile avatar);

    void delete(Long id);
}
