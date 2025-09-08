package ru.nicetu.crtris.crtrisbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;
import ru.nicetu.crtris.crtrisbackend.entity.Contacts;

@Mapper(componentModel = "spring")
public interface ContactsMapper {
    Contacts toEntity(ContactsRequest contactsRequest);
    ContactsResponse toResponse(Contacts contacts);
    void update(@MappingTarget Contacts contacts, ContactsRequest contactsRequest);
}
