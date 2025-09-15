package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.EducationItemRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.EducationItemResponse;

import java.util.List;

@Tag(name = "Education")
@RequestMapping("/education")
public interface EducationApi {

    @Operation(summary = "Публично: список образовательных карточек")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список получен"),
            @ApiResponse(responseCode = "404", description = "Список не найден")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<EducationItemResponse> findAll();

    @Operation(summary = "Публично: получить карточку по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Карточка получена"),
            @ApiResponse(responseCode = "404", description = "Карточка не найдена")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EducationItemResponse findById(@PathVariable Long id);

    @Operation(summary = "Admin: создать образовательную карточку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Карточка создана"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EducationItemResponse create(@Valid @RequestBody EducationItemRequest request);

    @Operation(summary = "Admin: обновить образовательную карточку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Карточка обновлена"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Карточка не найдена")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EducationItemResponse update(@PathVariable Long id,
                                 @Valid @RequestBody EducationItemRequest request );

    @Operation(summary = "Admin: удалить образовательную карточку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Карточка удалена"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);
}
