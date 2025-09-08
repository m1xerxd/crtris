package ru.nicetu.crtris.crtrisbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactsResponse {
    private String phoneNumber;
    private String telegram;
    private String email;
}
