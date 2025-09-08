package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.EducationItem;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.EducationMapper;
import ru.nicetu.crtris.crtrisbackend.repository.EducationItemRepository;
import ru.nicetu.crtris.crtrisbackend.service.EducationService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EducationServiceImpl implements EducationService {

    private final EducationItemRepository repo;
    private final EducationMapper mapper;

    @Override
    public List<EducationItemResponse> findAll() {
        return repo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EducationItemResponse findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Education item %d not found".formatted(id)));
    }

    @Override
    @Transactional
    public EducationItemResponse create(EducationItemRequest req) {
        var e = mapper.toEntity(req);

        if (e.getPosition() == null) {
            Integer max = repo.findAllByOrderByPositionAsc().stream()
                    .map(EducationItem::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            e.setPosition(max + 1);
        }
        return mapper.toResponse(repo.save(e));
    }

    @Override
    @Transactional
    public EducationItemResponse update(Long id, EducationItemRequest req) {
        var e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Education item %d not found".formatted(id)));

        mapper.update(e, req);
        return mapper.toResponse(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Education item %d not found".formatted(id));
        }
        repo.deleteById(id);
    }
}