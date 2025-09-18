package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.nicetu.crtris.crtrisbackend.dto.request.ContactsRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ContactsResponse;

@Tag(name = "Contacts")
@RequestMapping("/contacts")
public interface ContactsApi {

    @Operation(summary = "Публично: получить контактные данные")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ContactsResponse get();

    @Operation(summary = "Admin: обновить контактные данные")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Контакты обновлены"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    ContactsResponse update(@Valid @RequestBody ContactsRequest request);

    @Operation(summary = "Admin: удалить контактные данные")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Контакты удалены"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete();
}
