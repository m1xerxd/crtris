package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;

public interface AboutUsService {

    AboutUsResponse get();
    AboutUsResponse update(AboutUsUpdateRequest request);
}