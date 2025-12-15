package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import ru.nicetu.crtris.crtrisbackend.dto.request.ReviewRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.ReviewResponse;

import java.util.List;

@Tag(name = "Reviews")
@RequestMapping("/reviews")
public interface ReviewApi {

    @Operation(summary = "Публично: список отзывов")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ReviewResponse> findAll();

    @Operation(summary = "Публично: получить отзыв по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Отзыв получен"),
            @ApiResponse(responseCode = "404", description = "Отзыв не найден")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ReviewResponse findById(@PathVariable Long id);

    @Operation(
            summary = "Админ: Изменить отзыв по айди"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Отзыв создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    ReviewResponse create(
            @ModelAttribute("request") ReviewRequest request,
            @RequestPart(value = "avatar", required = false) MultipartFile avatar
    );

    @Operation(summary = "Админ: Изменить отзыв по айди")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Отзыв обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Отзыв не найден")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ReviewResponse update(
            @PathVariable Long id,
            @ModelAttribute("request") ReviewRequest request,
            @RequestPart(value = "avatar", required = false) MultipartFile avatar
);

    @Operation(summary = "Admin: удалить отзыв по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Отзыв удалён"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав"),
            @ApiResponse(responseCode = "404", description = "Отзыв не найден")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);
}
