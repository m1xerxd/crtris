package ru.nicetu.crtris.crtrisbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nicetu.crtris.crtrisbackend.controller.api.AuthApi;
import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.JwtAuthenticationResponse;
import ru.nicetu.crtris.crtrisbackend.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest req) {
        String token = authService.login(req);
        return new JwtAuthenticationResponse(token);
    }
}