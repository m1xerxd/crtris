package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;

public interface ContactsService {
    ContactsResponse get();

    ContactsResponse update(ContactsRequest req);

    void delete();
}