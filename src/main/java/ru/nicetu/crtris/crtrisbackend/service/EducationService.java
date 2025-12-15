package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;

import java.util.List;

public interface EducationService {
    List<EducationItemResponse> findAll();

    EducationItemResponse findById(Long id);

    EducationItemResponse create(EducationItemRequest educationItemRequest);

    EducationItemResponse update(Long id, EducationItemRequest educationItemRequest);

    void delete(Long id);
}
