package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;

import java.util.List;

public interface BenefitService {
    List<BenefitResponse> findAll();

    BenefitResponse findById(Long id);

    BenefitResponse create(BenefitRequest req);

    BenefitResponse update(Long id, BenefitRequest req);

    void delete(Long id);
}