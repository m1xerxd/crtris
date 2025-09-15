package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Benefit;
import ru.nicetu.crtris.crtrisbackend.mapper.BenefitMapper;
import ru.nicetu.crtris.crtrisbackend.repository.BenefitRepository;
import ru.nicetu.crtris.crtrisbackend.service.BenefitService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository repository;
    private final BenefitMapper mapper;

    @Override
    public List<BenefitResponse> findAll() {
        return repository.findAll(Sort.by("id").ascending())
                .stream().map(mapper::toResponse).toList();
    }

    @Override
    public BenefitResponse findById(Long id) {
        Benefit e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benefit не найден: " + id));
        return mapper.toResponse(e);
    }

    @Override
    @Transactional
    public BenefitResponse create(BenefitRequest request) {
        Benefit benefit = mapper.toEntity(request);
        benefit = repository.save(benefit);
        return mapper.toResponse(benefit);
    }

    @Override
    @Transactional
    public BenefitResponse update(Long id, BenefitRequest req) {
        Benefit benefit = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benefit не найден: " + id));
        mapper.update(benefit, req);
        benefit = repository.save(benefit);
        return mapper.toResponse(benefit);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Benefit не найден: " + id);
        }
        repository.deleteById(id);
    }
}