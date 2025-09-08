package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.FaqItem;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.FaqMapper;
import ru.nicetu.crtris.crtrisbackend.repository.FaqItemRepository;
import ru.nicetu.crtris.crtrisbackend.service.FaqService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FaqServiceImpl implements FaqService {

    private final FaqItemRepository repo;
    private final FaqMapper mapper;

    @Override
    public List<FaqItemResponse> findAll() {
        return repo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public FaqItemResponse findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Faq item %d not found".formatted(id)));
    }

    @Override
    @Transactional
    public FaqItemResponse create(FaqItemRequest req) {
        var e = mapper.toEntity(req);

        if (e.getPosition() == null) {
            Integer max = repo.findAllByOrderByPositionAsc().stream()
                    .map(FaqItem::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            e.setPosition(max + 1);
        }
        return mapper.toResponse(repo.save(e));
    }

    @Override
    @Transactional
    public FaqItemResponse update(Long id, FaqItemRequest req) {
        var e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Faq item %d not found".formatted(id)));
        mapper.update(e, req);
        return mapper.toResponse(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Faq item %d not found".formatted(id));
        }
        repo.deleteById(id);
    }
}