package ru.nicetu.crtris.crtrisbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsRequest {
    private String phoneNumber;
    private String telegram;
    private String email;
}