package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;

import java.util.List;

public interface MainService {
    MainResponse get();

    MainResponse update(MainUpdateRequest req);

    List<MainInfoResponse> listInfo();

    MainInfoResponse addInfo(MainInfoRequest req);

    MainInfoResponse updateInfo(Long id, MainInfoRequest req);

    void deleteInfo(Long id);
}
