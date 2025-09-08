package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;

import java.util.List;

public interface FaqService {
    List<FaqItemResponse> findAll();
    FaqItemResponse findById(Long id);
    FaqItemResponse create(FaqItemRequest req);
    FaqItemResponse update(Long id, FaqItemRequest req);
    void delete(Long id);
}
