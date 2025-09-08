package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;
import ru.nicetu.crtris.crtrisbackend.service.AboutService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAboutController {

    private final AboutService service;

    @GetMapping("/about")
    public AboutUsResponse getAbout() {
        return service.get();
    }

    @PutMapping("/about")
    @ResponseStatus(HttpStatus.OK)
    public void updateAboutDescription(@RequestParam String description) {
        service.updateDescription(description);
    }

    @GetMapping("/company-values")
    public List<CompanyValueResponse> listValues() {
        return service.listValues();
    }

    @PostMapping("/company-values")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyValueResponse createValue(@RequestBody @Valid CompanyValueRequest req) {
        return service.createValue(req);
    }

    @PutMapping("/company-values/{id}")
    public CompanyValueResponse updateValue(@PathVariable Long id, @RequestBody @Valid CompanyValueRequest req) {
        return service.updateValue(id, req);
    }

    @DeleteMapping("/company-values/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteValue(@PathVariable Long id) {
        service.deleteValue(id);
    }
}