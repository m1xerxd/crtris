package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;

import java.util.List;

public interface AboutService {

    AboutUsResponse get();
    void updateDescription(String description);

    List<CompanyValueResponse> listValues();
    CompanyValueResponse createValue(CompanyValueRequest req);
    CompanyValueResponse updateValue(Long id, CompanyValueRequest req);
    void deleteValue(Long id);
}