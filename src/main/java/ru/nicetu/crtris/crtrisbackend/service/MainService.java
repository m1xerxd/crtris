package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;

import java.util.List;

public interface MainService {

    MainResponse get();

    void updateDescription(String description);

    List<MainInfoResponse> listInfo();
    MainInfoResponse createInfo(MainInfoRequest req);
    MainInfoResponse updateInfo(Long id, MainInfoRequest req);
    void deleteInfo(Long id);
}