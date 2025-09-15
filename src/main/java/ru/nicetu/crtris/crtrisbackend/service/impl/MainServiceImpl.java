package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Main;
import ru.nicetu.crtris.crtrisbackend.entity.MainInfo;
import ru.nicetu.crtris.crtrisbackend.mapper.MainMapper;
import ru.nicetu.crtris.crtrisbackend.repository.MainInfoRepository;
import ru.nicetu.crtris.crtrisbackend.repository.MainRepository;
import ru.nicetu.crtris.crtrisbackend.service.MainService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepository;
    private final MainInfoRepository infoRepository;
    private final MainMapper mapper;

    private Main getOrCreateMain() {
        return mainRepository.findTopByOrderByIdAsc()
                .orElseGet(() -> mainRepository.save(new Main()));
    }

    @Override
    public MainResponse get() {
        return mapper.toResponse(getOrCreateMain());
    }

    @Override
    @Transactional
    public MainResponse update(MainUpdateRequest req) {
        Main main = getOrCreateMain();
        mapper.update(main, req);
        main = mainRepository.save(main);
        return mapper.toResponse(main);
    }

    @Override
    public List<MainInfoResponse> listInfo() {
        return infoRepository.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public MainInfoResponse addInfo(MainInfoRequest req) {
        Main main = getOrCreateMain();

        MainInfo info = mapper.toEntity(req);
        info.setMain(main);

        if (info.getPosition() == null) {
            Integer max = infoRepository.findAllByOrderByPositionAsc().stream()
                    .map(MainInfo::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            info.setPosition(max + 1);
        }
        info = infoRepository.save(info);
        return mapper.toResponse(info);
    }

    @Override
    @Transactional
    public MainInfoResponse updateInfo(Long id, MainInfoRequest req) {
        MainInfo info = infoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MainInfo %d не найдено".formatted(id)));
        mapper.update(info, req);
        info = infoRepository.save(info);
        return mapper.toResponse(info);
    }

    @Override
    @Transactional
    public void deleteInfo(Long id) {
        if (!infoRepository.existsById(id)) {
            throw new IllegalArgumentException("MainInfo %d не найдено".formatted(id));
        }
        infoRepository.deleteById(id);
    }
}