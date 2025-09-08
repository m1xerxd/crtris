package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.Main;
import ru.nicetu.crtris.crtrisbackend.entity.MainInfo;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.MainMapper;
import ru.nicetu.crtris.crtrisbackend.repository.MainInfoRepository;
import ru.nicetu.crtris.crtrisbackend.repository.MainRepository;
import ru.nicetu.crtris.crtrisbackend.service.MainService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepo;
    private final MainInfoRepository infoRepo;
    private final MainMapper mapper;

    private Main getOrCreateMain() {
        return mainRepo.findTopByOrderByIdAsc()
                .orElseGet(() -> mainRepo.save(Main.builder()
                        .description(null)
                        .build()));
    }

    @Override
    public MainResponse get() {
        var main = getOrCreateMain();
        return mapper.toResponse(main);
    }

    @Override
    @Transactional
    public void updateDescription(String description) {
        var main = getOrCreateMain();
        main.setDescription(description);
    }

    @Override
    public List<MainInfoResponse> listInfo() {
        return infoRepo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public MainInfoResponse createInfo(MainInfoRequest req) {
        var main = getOrCreateMain();

        MainInfo info = mapper.toEntity(req);
        info.setMain(main);

        if (info.getPosition() == null) {
            Integer max = infoRepo.findAllByOrderByPositionAsc().stream()
                    .map(MainInfo::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            info.setPosition(max + 1);
        }
        return mapper.toResponse(infoRepo.save(info));
    }

    @Override
    @Transactional
    public MainInfoResponse updateInfo(Long id, MainInfoRequest req) {
        var info = infoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MainInfo %d not found".formatted(id)));
        mapper.update(info, req);
        return mapper.toResponse(info);
    }

    @Override
    @Transactional
    public void deleteInfo(Long id) {
        if (!infoRepo.existsById(id)) {
            throw new IllegalArgumentException("MainInfo %d not found".formatted(id));
        }
        infoRepo.deleteById(id);
    }
}