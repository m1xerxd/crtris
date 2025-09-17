package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.JwtAuthenticationResponse;

@Tag(name = "Authentication")
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Публично: вход (логин), возвращает JWT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешная аутентификация, токен выдан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Неверные учётные данные")
    })
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest request);
}
