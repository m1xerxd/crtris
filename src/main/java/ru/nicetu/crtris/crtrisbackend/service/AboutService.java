package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;

import java.util.List;

public interface AboutService {

    AboutUsResponse get();
    AboutUsResponse updateDescription(AboutUsUpdateRequest request);

    List<CompanyValueResponse> listValues();
    CompanyValueResponse createValue(CompanyValueRequest request);
    CompanyValueResponse updateValue(Long id, CompanyValueRequest request);
    void deleteValue(Long id);
}