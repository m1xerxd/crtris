package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Contacts;
import ru.nicetu.crtris.crtrisbackend.exception.NotFoundException;
import ru.nicetu.crtris.crtrisbackend.mapper.ContactsMapper;
import ru.nicetu.crtris.crtrisbackend.repository.ContactsRepository;
import ru.nicetu.crtris.crtrisbackend.service.ContactsService;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository repository;
    private final ContactsMapper mapper;


    private Contacts getRequiredContacts() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Контакты не инициализированы"));
    }

    @Override
    @Transactional(readOnly = true)
    public ContactsResponse get() {
        return mapper.toResponse(getRequiredContacts());
    }

    @Override
    @Transactional
    public ContactsResponse update(ContactsRequest req) {
        Contacts contacts = getRequiredContacts();
        mapper.update(contacts, req);
        contacts = repository.save(contacts);
        return mapper.toResponse(contacts);
    }

    @Override
    @Transactional
    public void delete() {
        repository.deleteAll();
    }
}