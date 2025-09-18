package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}