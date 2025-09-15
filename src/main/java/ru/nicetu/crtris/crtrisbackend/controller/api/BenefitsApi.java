package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.BenefitRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.BenefitResponse;

import java.util.List;

@Tag(name = "Benefits")
@RequestMapping("/benefits")
public interface BenefitsApi {

    @Operation(summary = "Публично: список benefits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Список benefits получен"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<BenefitResponse> findAll();

    @Operation(summary = "Публично: получить benefit по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "benefit полуен"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BenefitResponse findById(@PathVariable Long id);

    @Operation(summary = "Admin: создать benefit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Создано"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
    })
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    BenefitResponse create(@Valid @RequestBody BenefitRequest request);

    @Operation(summary = "Admin: обновить benefit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Обновлено"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BenefitResponse update(@PathVariable Long id,
                           @Valid @RequestBody BenefitRequest request);

    @Operation(summary = "Admin: удаление benefit по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалено"),
            @ApiResponse(responseCode = "401", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "403", description = "Не авторизован"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);
}
