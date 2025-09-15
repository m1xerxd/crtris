package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.AboutUsApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.service.AboutService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AboutUsController implements AboutUsApi {

    private final AboutService service;

    @Override
    public AboutUsResponse get() {
        return service.get();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public AboutUsResponse update(AboutUsUpdateRequest request) {
        return service.updateDescription(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CompanyValueResponse addValue(CompanyValueRequest request) {
        return service.createValue(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CompanyValueResponse updateValue(Long id, CompanyValueRequest request) {
        return service.updateValue(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteValue(Long id) {
        service.deleteValue(id);
    }

    @Override
    public List<CompanyValueResponse> listValues() {
        return service.listValues();
    }
}