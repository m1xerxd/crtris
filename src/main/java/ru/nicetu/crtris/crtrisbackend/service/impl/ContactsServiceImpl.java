package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.Contacts;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;
import ru.nicetu.crtris.crtrisbackend.mapper.ContactsMapper;
import ru.nicetu.crtris.crtrisbackend.repository.ContactsRepository;
import ru.nicetu.crtris.crtrisbackend.service.ContactsService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository repo;
    private final ContactsMapper mapper;

    private Contacts getOrCreateContacts() {
        return repo.findTopByOrderByIdAsc()
                .orElseGet(() -> repo.save(new Contacts()));
    }

    @Override
    public ContactsResponse get() {
        return mapper.toResponse(getOrCreateContacts());
    }

    @Override
    @Transactional
    public ContactsResponse update(ContactsRequest req) {
        Contacts c = getOrCreateContacts();
        mapper.update(c, req);
        return mapper.toResponse(c);
    }
}