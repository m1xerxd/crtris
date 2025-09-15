package ru.nicetu.crtris.crtrisbackend.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.AuthApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.TokenResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CurrentUserResponse;
import ru.nicetu.crtris.crtrisbackend.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public TokenResponse login(LoginRequest request) {
        return authService.login(request);
    }

    @Override
    public CurrentUserResponse current() {
        return authService.current();
    }
}