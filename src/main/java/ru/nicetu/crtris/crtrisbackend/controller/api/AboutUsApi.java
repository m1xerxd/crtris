package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.CompanyValueRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.CompanyValueResponse;

import java.util.List;

@Tag(name = "AboutUs")
@RequestMapping("/AboutUs")
public interface AboutUsApi {

    @Operation(summary = "Публично: раздел AboutUs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Раздел AboutUs получен"),
            @ApiResponse(responseCode = "404", description = "Раздел AboutUs не найден")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    AboutUsResponse get();

    @Operation(summary = "Admin: обновить описание AboutUs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Описание обновлено"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Раздел AboutUs не найден")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    AboutUsResponse update(@Valid @RequestBody AboutUsUpdateRequest request);

    @Operation(summary = "Admin: добавить ценность компании")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ценности компании успешно добавлены"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
    })
    @PostMapping("/values")
    @ResponseStatus(HttpStatus.CREATED)
    CompanyValueResponse addValue(@Valid @RequestBody CompanyValueRequest request);

    @Operation(summary = "Admin: обновить ценность компании по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ценность компании обновлена"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Ценность компании не найдена")
    })
    @PutMapping("/values/{id}")
    @ResponseStatus(HttpStatus.OK)
    CompanyValueResponse updateValue(
            @PathVariable Long id,
            @Valid @RequestBody CompanyValueRequest request
    );

    @Operation(summary = "Admin: удалить ценность компании по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ценность компании была успешно удалена"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Ценность компании не найдена")
    })
    @DeleteMapping("/values/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteValue(@PathVariable Long id);

    @Operation(summary = "Публично: раздел CompanyValues")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Раздел CompanyValues получен"),
            @ApiResponse(responseCode = "404", description = "Раздел CompanyValues не найден")
    })
    @GetMapping("/values")
    @ResponseStatus(HttpStatus.OK)
    List<CompanyValueResponse> listValues();
}