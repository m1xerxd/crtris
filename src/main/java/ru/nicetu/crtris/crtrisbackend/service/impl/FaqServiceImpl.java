package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.entity.FaqItem;
import ru.nicetu.crtris.crtrisbackend.mapper.FaqMapper;
import ru.nicetu.crtris.crtrisbackend.repository.FaqItemRepository;
import ru.nicetu.crtris.crtrisbackend.service.FaqService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

    private final FaqItemRepository repository;
    private final FaqMapper mapper;

    @Override
    public List<FaqItemResponse> findAll() {
        return repository.findAll(Sort.by("id").ascending())
                .stream().map(mapper::toResponse).toList();
    }

    @Override
    public FaqItemResponse findById(Long id) {
        FaqItem faqItem = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FAQ не найдено: " + id));
        return mapper.toResponse(faqItem);
    }

    @Override
    @Transactional
    public FaqItemResponse create(FaqItemRequest request) {
        FaqItem faqItem = mapper.toEntity(request);
        faqItem = repository.save(faqItem);
        return mapper.toResponse(faqItem);
    }

    @Override
    @Transactional
    public FaqItemResponse update(Long id, FaqItemRequest request) {
        FaqItem faqItem = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FAQ не найдено: " + id));
        mapper.update(faqItem, request);
        faqItem = repository.save(faqItem);
        return mapper.toResponse(faqItem);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("FAQ не найдено: " + id);
        }
        repository.deleteById(id);
    }
}