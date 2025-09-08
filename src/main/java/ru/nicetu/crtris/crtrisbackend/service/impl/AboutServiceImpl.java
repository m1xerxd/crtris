package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.AboutUsMapper;
import ru.nicetu.crtris.crtrisbackend.repository.AboutUsRepository;
import ru.nicetu.crtris.crtrisbackend.repository.CompanyValueRepository;
import ru.nicetu.crtris.crtrisbackend.service.AboutService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AboutServiceImpl implements AboutService {

    private final AboutUsRepository aboutRepo;
    private final CompanyValueRepository valueRepo;
    private final AboutUsMapper mapper;

    private AboutUs getOrCreateAbout() {
        return aboutRepo.findTopByOrderByIdAsc()
                .orElseGet(() -> aboutRepo.save(
                        AboutUs.builder().description(null).build()
                ));
    }

    @Override
    public AboutUsResponse get() {
        return mapper.toResponse(getOrCreateAbout());
    }

    @Override
    @Transactional
    public void updateDescription(String description) {
        AboutUs about = getOrCreateAbout();
        about.setDescription(description);
    }

    @Override
    public List<CompanyValueResponse> listValues() {
        return valueRepo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public CompanyValueResponse createValue(CompanyValueRequest req) {
        AboutUs about = getOrCreateAbout();

        CompanyValue v = mapper.toEntity(req);
        v.setAboutUs(about);

        if (v.getPosition() == null) {
            Integer max = valueRepo.findAllByOrderByPositionAsc().stream()
                    .map(CompanyValue::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            v.setPosition(max + 1);
        }

        return mapper.toResponse(valueRepo.save(v));
    }

    @Override
    @Transactional
    public CompanyValueResponse updateValue(Long id, CompanyValueRequest req) {
        CompanyValue v = valueRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CompanyValue %d not found".formatted(id)));
        mapper.update(v, req);
        return mapper.toResponse(v);
    }

    @Override
    @Transactional
    public void deleteValue(Long id) {
        if (!valueRepo.existsById(id)) {
            throw new IllegalArgumentException("CompanyValue %d not found".formatted(id));
        }
        valueRepo.deleteById(id);
    }
}