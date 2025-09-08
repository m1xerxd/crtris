package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;
import ru.nicetu.crtris.crtrisbackend.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("/admin/education")
@RequiredArgsConstructor
public class AdminEducationController {

    private final EducationService service;

    @GetMapping
    public List<EducationItemResponse> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EducationItemResponse one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationItemResponse create(@RequestBody @Valid EducationItemRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public EducationItemResponse update(@PathVariable Long id, @RequestBody @Valid EducationItemRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}