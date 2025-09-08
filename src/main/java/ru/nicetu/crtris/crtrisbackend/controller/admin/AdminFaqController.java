package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;
import ru.nicetu.crtris.crtrisbackend.service.FaqService;

import java.util.List;

@RestController
@RequestMapping("/admin/faq")
@RequiredArgsConstructor
public class AdminFaqController {

    private final FaqService service;

    @GetMapping
    public List<FaqItemResponse> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public FaqItemResponse one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FaqItemResponse create(@RequestBody @Valid FaqItemRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public FaqItemResponse update(@PathVariable Long id, @RequestBody @Valid FaqItemRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}