package ru.nicetu.crtris.crtrisbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.EducationApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;
import ru.nicetu.crtris.crtrisbackend.service.EducationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController implements EducationApi {

    private final EducationService service;

    @Override
    public List<EducationItemResponse> findAll(){
        return service.findAll();
    }

    @Override
    public EducationItemResponse findById(Long id) {
        return service.findById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public EducationItemResponse create(@Valid EducationItemRequest request) {
        return service.create(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public EducationItemResponse update(Long id, @Valid EducationItemRequest request) {
        return service.update(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        service.delete(id);
    }
}