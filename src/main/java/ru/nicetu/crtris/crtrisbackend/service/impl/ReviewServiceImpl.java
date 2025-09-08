package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.Review;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.ReviewMapper;
import ru.nicetu.crtris.crtrisbackend.repository.ReviewRepository;
import ru.nicetu.crtris.crtrisbackend.service.ReviewService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repo;
    private final ReviewMapper mapper;

    @Override
    public List<ReviewResponse> findAll() {
        return repo.findAllByOrderByPositionAsc().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public ReviewResponse findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Review %d not found".formatted(id)));
    }

    @Override @Transactional
    public ReviewResponse create(ReviewRequest req) {
        Review e = mapper.toEntity(req);

        if (e.getPosition() == null) {
            Integer max = repo.findAllByOrderByPositionAsc().stream()
                    .map(Review::getPosition)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::max);
            e.setPosition(max + 1);
        }
        return mapper.toResponse(repo.save(e));
    }

    @Override @Transactional
    public ReviewResponse update(Long id, ReviewRequest req) {
        Review e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Review %d not found".formatted(id)));
        mapper.update(e, req);
        return mapper.toResponse(e);
    }

    @Override @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Review %d not found".formatted(id));
        }
        repo.deleteById(id);
    }
}