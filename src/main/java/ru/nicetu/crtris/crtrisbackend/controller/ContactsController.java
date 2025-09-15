package ru.nicetu.crtris.crtrisbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.ContactsApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;
import ru.nicetu.crtris.crtrisbackend.service.ContactsService;

@RestController
@RequiredArgsConstructor
public class ContactsController implements ContactsApi {
    private final ContactsService service;

    @Override
    public ContactsResponse get() {
        return service.get();
    }


    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ContactsResponse update(ContactsRequest request) {
        return service.update(request);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete() {
        service.delete();
    }
}
