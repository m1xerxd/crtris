package ru.nicetu.crtris.crtrisbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.BenefitsApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.service.BenefitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitsController implements BenefitsApi {

    private final BenefitService service;

    @Override
    public List<BenefitResponse> findAll() {
        return service.findAll();
    }

    @Override
    public BenefitResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public BenefitResponse create(@Valid BenefitRequest request) {
        return service.create(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public BenefitResponse update(Long id, @Valid BenefitRequest request) {
        return service.update(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        service.delete(id);
    }
}