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
import ru.nicetu.crtris.crtrisbackend.dto.request.MainInfoRequest;
import ru.nicetu.crtris.crtrisbackend.dto.request.MainUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainInfoResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.MainResponse;

import java.util.List;

@Tag(name = "Main")
@RequestMapping("/main")
public interface MainApi {

    @Operation(summary = "Публично: получить раздел Main")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    MainResponse get();

    @Operation(summary = "Admin: обновить раздел Main")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Раздел обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    MainResponse update(@Valid @RequestBody MainUpdateRequest request);

    @Operation(summary = "Публично: список info-элементов")
    @GetMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    List<MainInfoResponse> listInfo();

    @Operation(summary = "Admin: добавить info-элемент")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Info-элемент создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PostMapping("/info")
    @ResponseStatus(HttpStatus.CREATED)
    MainInfoResponse addInfo(@Valid @RequestBody MainInfoRequest request);

    @Operation(summary = "Admin: обновить info-элемент по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Info-элемент обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Info-элемент не найден")
    })
    @PutMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    MainInfoResponse updateInfo(@PathVariable Long id,
                                @Valid @RequestBody MainInfoRequest request);

    @Operation(summary = "Admin: удалить info-элемент по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Info-элемент удалён"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Info-элемент не найден")
    })
    @DeleteMapping("/info/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInfo(@PathVariable Long id);
}
