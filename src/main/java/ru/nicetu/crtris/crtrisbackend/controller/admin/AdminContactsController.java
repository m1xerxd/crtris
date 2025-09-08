package ru.nicetu.crtris.crtrisbackend.controller.admin;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;
import ru.nicetu.crtris.crtrisbackend.service.ContactsService;

@RestController
@RequestMapping("/admin/contacts")
@RequiredArgsConstructor
public class AdminContactsController {

    private final ContactsService service;

    @GetMapping
    public ContactsResponse get() {
        return service.get();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ContactsResponse update(@RequestBody @Valid ContactsRequest req) {
        return service.update(req);
    }
}