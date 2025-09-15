package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;
import ru.nicetu.crtris.crtrisbackend.mapper.AboutUsMapper;
import ru.nicetu.crtris.crtrisbackend.repository.AboutUsRepository;
import ru.nicetu.crtris.crtrisbackend.repository.CompanyValueRepository;
import ru.nicetu.crtris.crtrisbackend.service.AboutService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AboutServiceImpl implements AboutService {

    private final AboutUsRepository aboutUsRepository;
    private final CompanyValueRepository valueRepository;
    private final AboutUsMapper mapper;

    private AboutUs findOrInit() {
        return aboutUsRepository.findTopByOrderByIdAsc()
                .orElseGet(() -> aboutUsRepository.save(new AboutUs()));
    }

    @Override
    public AboutUsResponse get() {
        return mapper.toResponse(findOrInit());
    }

    @Override
    @Transactional
    public AboutUsResponse updateDescription(AboutUsUpdateRequest request) {
        AboutUs about = findOrInit();
        mapper.update(about, request);
        about = aboutUsRepository.save(about);
        return mapper.toResponse(about);
    }

    @Override
    @Transactional
    public CompanyValueResponse createValue(CompanyValueRequest request) {
        CompanyValue value = mapper.toEntity(request);
        value = valueRepository.save(value);
        return mapper.toResponse(value);
    }

    @Override
    @Transactional
    public CompanyValueResponse updateValue(Long id, CompanyValueRequest request) {
        CompanyValue value = valueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CompanyValue не найдена: " + id));
        mapper.update(value, request);
        value = valueRepository.save(value);
        return mapper.toResponse(value);
    }

    @Override
    @Transactional
    public void deleteValue(Long id) {
        if (!valueRepository.existsById(id)) {
            throw new IllegalArgumentException("CompanyValue не найдена: " + id);
        }
        valueRepository.deleteById(id);
    }

    @Override
    public List<CompanyValueResponse> listValues() {
        return valueRepository.findAllByOrderByPositionAsc()
                .stream().map(mapper::toResponse)
                .toList();
    }
}