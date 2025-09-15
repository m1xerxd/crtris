package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;
import ru.nicetu.crtris.crtrisbackend.entity.EducationItem;
import ru.nicetu.crtris.crtrisbackend.mapper.EducationMapper;
import ru.nicetu.crtris.crtrisbackend.repository.EducationItemRepository;
import ru.nicetu.crtris.crtrisbackend.service.EducationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationItemRepository repository;
    private final EducationMapper mapper;

    @Override
    public List<EducationItemResponse> findAll() {
        return repository.findAll(Sort.by("id").ascending())
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EducationItemResponse findById(Long id) {
        EducationItem educationItem = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Education не найден: " + id));
        return mapper.toResponse(educationItem);
    }

    @Override
    @Transactional
    public EducationItemResponse create(EducationItemRequest req) {
        EducationItem educationItem = mapper.toEntity(req);
        educationItem = repository.save(educationItem);
        return mapper.toResponse(educationItem);
    }

    @Override
    @Transactional
    public EducationItemResponse update(Long id, EducationItemRequest request) {
        EducationItem educationItem = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Education не найден: " + id));
        mapper.update(educationItem, request);
        educationItem = repository.save(educationItem);
        return mapper.toResponse(educationItem);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Education не найден: " + id);
        }
        repository.deleteById(id);
    }
}