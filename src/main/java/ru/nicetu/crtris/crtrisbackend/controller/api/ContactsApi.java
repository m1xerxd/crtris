package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;

@Tag(name = "Contacts")
@RequestMapping("/contacts")
public interface ContactsApi {

    @Operation(summary = "Публично: получить все контакты")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Контакты получены"),
            @ApiResponse(responseCode = "404", description = "Контакты не найдены:(")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ContactsResponse get();

    @Operation(summary = "Admin: обновить контактные данные")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Контакты обновлены"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    ContactsResponse update(@Valid @RequestBody ContactsRequest request);

    @Operation(summary = "Admin: удалить контакнтые данные")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Контакты удалены"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete();
}
