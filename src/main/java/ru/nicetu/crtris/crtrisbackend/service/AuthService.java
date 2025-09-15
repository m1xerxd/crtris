package ru.nicetu.crtris.crtrisbackend.service;

import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.TokenResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CurrentUserResponse;

public interface AuthService {
    TokenResponse login(LoginRequest request);
    CurrentUserResponse current();
}