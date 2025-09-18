package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.ReviewApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;
import ru.nicetu.crtris.crtrisbackend.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController implements ReviewApi {

    private final ReviewService service;

    @Override
    public List<ReviewResponse> findAll() {
        return service.findAll();
    }

    @Override
    public ReviewResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ReviewResponse create(ReviewRequest request) {
        return service.create(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ReviewResponse update(Long id, ReviewRequest request) {
        return service.update(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        service.delete(id);
    }

}