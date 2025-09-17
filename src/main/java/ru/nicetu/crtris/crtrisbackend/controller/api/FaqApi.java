package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.nicetu.crtris.crtrisbackend.dto.request.FaqItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.FaqItemResponse;

import java.util.List;

@Tag(name = "FAQ")
@RequestMapping("/faq")
public interface FaqApi {

    @Operation(summary = "Публично: список FAQ")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<FaqItemResponse> findAll();

    @Operation(summary = "Публично: получить FAQ по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "FAQ получен"),
            @ApiResponse(responseCode = "404", description = "FAQ не найден")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FaqItemResponse findById(@PathVariable Long id);

    @Operation(summary = "Admin: создать FAQ")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "FAQ создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FaqItemResponse create(@Valid @RequestBody FaqItemRequest request);

    @Operation(summary = "Admin: обновить FAQ по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "FAQ обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "FAQ не найден")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FaqItemResponse update(@PathVariable Long id,
                           @Valid @RequestBody FaqItemRequest request);

    @Operation(summary = "Admin: удалить FAQ по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "FAQ удалён"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "FAQ не найден")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);
}
