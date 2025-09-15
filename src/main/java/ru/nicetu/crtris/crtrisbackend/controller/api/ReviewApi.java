package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;

import java.util.List;

@Tag(name = "Reviews")
@RequestMapping("/reviews")
public interface ReviewApi {

    @Operation(summary = "Публично: получить список отзывов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список получен"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ReviewResponse> findAll();

    @Operation(summary = "Публично: получить отзыв по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отзыв получен"),
            @ApiResponse(responseCode = "404", description = "Не найдено"),
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ReviewResponse findById(@PathVariable Long id);

    @Operation(summary = "Admin: создать отзыв")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отзыв создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ReviewResponse create(@Valid @RequestBody ReviewRequest request);

    @Operation(summary = "Admin: обновить отзыв по id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отзыв успешно обновлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ReviewResponse update(@PathVariable Long id, @Valid @RequestBody ReviewRequest reviewRequest);

    @Operation(summary = "Admin: удалить отзыв по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отзыв удален"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Не найдено")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);
}
