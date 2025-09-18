package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.entity.AboutUs;
import ru.nicetu.crtris.crtrisbackend.entity.CompanyValue;
import ru.nicetu.crtris.crtrisbackend.exception.NotFoundException;
import ru.nicetu.crtris.crtrisbackend.mapper.AboutUsMapper;
import ru.nicetu.crtris.crtrisbackend.repository.AboutUsRepository;
import ru.nicetu.crtris.crtrisbackend.service.AboutUsService;

@Service
@RequiredArgsConstructor
public class AboutUsServiceImpl implements AboutUsService {

    private final AboutUsRepository aboutUsRepository;
    private final AboutUsMapper mapper;

    private AboutUs getRequired() {
        return aboutUsRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Раздел «О компании» не инициализирован"));
    }

    @Override
    @Transactional(readOnly = true)
    public AboutUsResponse get() {
        return mapper.toResponse(getRequired());
    }

    @Override
    @Transactional
    public AboutUsResponse update(AboutUsUpdateRequest request) {
        AboutUs aboutUs = getRequired();

        mapper.update(aboutUs, request);

        if (request.companyValues() != null) {
            aboutUs.getCompanyValues().clear();
            for (CompanyValueRequest r : request.companyValues()) {
                CompanyValue cv = mapper.toEntity(r);
                cv.setAboutUs(aboutUs);
                aboutUs.getCompanyValues().add(cv);
            }
        }
        return mapper.toResponse(aboutUsRepository.save(aboutUs));
    }
}