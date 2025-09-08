package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;
import ru.nicetu.crtris.crtrisbackend.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/admin/main")
@RequiredArgsConstructor
public class AdminMainController {

    private final MainService service;

    @GetMapping
    public MainResponse get() { return service.get(); }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateDescription(@RequestParam String description) {
        service.updateDescription(description);
    }

    @GetMapping("/info")
    public List<MainInfoResponse> listInfo() { return service.listInfo(); }

    @PostMapping("/info")
    @ResponseStatus(HttpStatus.CREATED)
    public MainInfoResponse createInfo(@RequestBody @Valid MainInfoRequest req) {
        return service.createInfo(req);
    }

    @PutMapping("/info/{id}")
    public MainInfoResponse updateInfo(@PathVariable Long id, @RequestBody @Valid MainInfoRequest req) {
        return service.updateInfo(id, req);
    }

    @DeleteMapping("/info/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInfo(@PathVariable Long id) { service.deleteInfo(id); }
}