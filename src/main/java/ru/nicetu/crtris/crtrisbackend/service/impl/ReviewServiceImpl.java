package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Review;
import ru.nicetu.crtris.crtrisbackend.exception.NotFoundException;
import ru.nicetu.crtris.crtrisbackend.mapper.ReviewMapper;
import ru.nicetu.crtris.crtrisbackend.repository.ReviewRepository;
import ru.nicetu.crtris.crtrisbackend.service.ReviewService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;
    private final FileStorageService fileStorageService;

    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReviewResponse findById(Long id) {
        Review review = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review не найдено: " + id));
        return mapper.toResponse(review);
    }

    @Override
    @Transactional
    public ReviewResponse create(ReviewRequest request, MultipartFile avatar) {
        Review review = mapper.toEntity(request);

        if (avatar != null && !avatar.isEmpty()) {
            review.setAvatar(fileStorageService.storeReviewAvatar(avatar));
        } else {
            review.setAvatar("/assets/reviews/default.png");
        }

        review = repository.save(review);
        return mapper.toResponse(review);
    }

    @Override
    @Transactional
    public ReviewResponse update(Long id, ReviewRequest request, MultipartFile avatar) {
        Review review = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review не найдено: " + id));

        mapper.update(review, request);

        if (avatar != null && !avatar.isEmpty()) {
            review.setAvatar(fileStorageService.storeReviewAvatar(avatar));
        }

        return mapper.toResponse(repository.save(review));
    }


    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Review не найдено: " + id);
        }
        repository.deleteById(id);
    }
}