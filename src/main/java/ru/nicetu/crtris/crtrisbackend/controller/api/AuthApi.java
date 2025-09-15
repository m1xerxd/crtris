package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.TokenResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CurrentUserResponse;

@Tag(name = "Authentication")
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Публично: вход в систему (логин), возвращает JWT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешная аутентификация, токен выдан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Неверные учетные данные")
    })
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    TokenResponse login(@Valid @RequestBody LoginRequest request);

    @Operation(summary = "Текущий пользователь", description = "Возвращает данные текущего пользователя по токену")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Данные пользователя получены"),
            @ApiResponse(responseCode = "401", description = "Не авторизован")
    })
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    CurrentUserResponse current();
}