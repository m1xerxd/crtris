package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;

public interface ContactsService {
    ContactsResponse get();                        // получить контакты
    ContactsResponse update(ContactsRequest req);  // обновить контакты
}