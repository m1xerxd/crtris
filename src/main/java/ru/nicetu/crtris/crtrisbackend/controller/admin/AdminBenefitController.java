package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;
import ru.nicetu.crtris.crtrisbackend.service.BenefitService;

import java.util.List;

@RestController
@RequestMapping("/admin/benefits")
@RequiredArgsConstructor
public class AdminBenefitController {

    private final BenefitService service;

    @GetMapping
    public List<BenefitResponse> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public BenefitResponse one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BenefitResponse create(@RequestBody @Valid BenefitRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public BenefitResponse update(@PathVariable Long id, @RequestBody @Valid BenefitRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}