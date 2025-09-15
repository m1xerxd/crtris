package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import ru.nicetu.crtris.crtrisbackend.controller.api.FaqApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.service.FaqService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FaqController implements FaqApi {
    private final FaqService service;

    @Override
    public List<FaqItemResponse> findAll() {
        return service.findAll();
    }

    @Override
    public FaqItemResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FaqItemResponse create(FaqItemRequest request) {
        return service.create(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FaqItemResponse update(Long id, FaqItemRequest request) {
        return service.update(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        service.delete(id);
    }
}