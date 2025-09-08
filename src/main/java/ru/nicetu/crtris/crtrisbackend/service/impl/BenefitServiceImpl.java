package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.Benefit;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.BenefitMapper;
import ru.nicetu.crtris.crtrisbackend.repository.BenefitRepository;
import ru.nicetu.crtris.crtrisbackend.service.BenefitService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository repo;
    private final BenefitMapper mapper;

    @Override
    public List<BenefitResponse> findAll() {
        return repo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public BenefitResponse findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Benefit %d not found".formatted(id)));
    }

    @Override
    @Transactional
    public BenefitResponse create(BenefitRequest req) {
        var e = mapper.toEntity(req);

        if (e.getPosition() == null) {
            Integer max = repo.findAllByOrderByPositionAsc().stream()
                    .map(Benefit::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            e.setPosition(max + 1);
        }
        return mapper.toResponse(repo.save(e));
    }

    @Override
    @Transactional
    public BenefitResponse update(Long id, BenefitRequest req) {
        var e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benefit %d not found".formatted(id)));
        mapper.update(e, req);
        return mapper.toResponse(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Benefit %d not found".formatted(id));
        }
        repo.deleteById(id);
    }
}