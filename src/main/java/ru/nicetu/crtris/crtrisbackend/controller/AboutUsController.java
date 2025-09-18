package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.AboutUsApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.service.AboutUsService;

@RestController
@RequiredArgsConstructor
public class AboutUsController implements AboutUsApi {

    private final AboutUsService service;

    @Override
    public AboutUsResponse get() {
        return service.get();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public AboutUsResponse update(AboutUsUpdateRequest request) {
        return service.update(request);
    }
}