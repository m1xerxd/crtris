package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.MainApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;
import ru.nicetu.crtris.crtrisbackend.service.MainService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController implements MainApi {
    private final MainService service;

    @Override
    public MainResponse get() {
        return service.get();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MainResponse update(MainUpdateRequest request) {
        return service.update(request);
    }

    @Override
    public List<MainInfoResponse> listInfo() {
        return service.listInfo();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MainInfoResponse addInfo(MainInfoRequest request) {
        return service.addInfo(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MainInfoResponse updateInfo(Long id, MainInfoRequest request) {
        return service.updateInfo(id, request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteInfo(Long id) {
        service.deleteInfo(id);
    }
}