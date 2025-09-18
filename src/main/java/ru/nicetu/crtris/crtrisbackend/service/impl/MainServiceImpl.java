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
    import ru.nicetu.crtris.crtrisbackend.exception.NotFoundException;
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

        private Main getRequiredMain() {
            return mainRepository.findAll()
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Главный блок (Main) не инициализирован"));
        }

        @Override
        @Transactional(readOnly = true)
        public MainResponse get() {
            return mapper.toMainResponse(getRequiredMain());
        }

        @Override
        @Transactional
        public MainResponse update(MainUpdateRequest req) {
            Main main = getRequiredMain();
            mapper.update(main, req);
            main = mainRepository.save(main);
            return mapper.toMainResponse(main);
        }

        @Override
        @Transactional(readOnly = true)
        public List<MainInfoResponse> listInfo() {
            return infoRepository.findAll().stream()
                    .map(mapper::toMainInfoResponse)
                    .toList();
        }

        @Override
        @Transactional
        public MainInfoResponse addInfo(MainInfoRequest req) {
            Main main = getRequiredMain();

            MainInfo info = mapper.toEntity(req);
            info.setMain(main);

            if (info.getPosition() == null) {
                int max = infoRepository.findAll().stream()
                        .map(MainInfo::getPosition)
                        .filter(Objects::nonNull)
                        .max(Integer::compareTo)
                        .orElse(0);
                info.setPosition(max + 1);
            }

            info = infoRepository.save(info);
            return mapper.toMainInfoResponse(info);
        }

        @Override
        @Transactional
        public MainInfoResponse updateInfo(Long id, MainInfoRequest req) {
            MainInfo info = infoRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Элемент MainInfo %d не найден".formatted(id)));
            mapper.update(info, req);
            info = infoRepository.save(info);
            return mapper.toMainInfoResponse(info);
        }

        @Override
        @Transactional
        public void deleteInfo(Long id) {
            if (!infoRepository.existsById(id)) {
                throw new NotFoundException("Элемент MainInfo %d не найден".formatted(id));
            }
            infoRepository.deleteById(id);
        }
    }