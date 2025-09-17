package ru.nicetu.crtris.crtrisbackend.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.nicetu.crtris.crtrisbackend.dto.request.AboutUsUpdateRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.AboutUsResponse;

@Tag(name = "AboutUs")
@RequestMapping("/about")
public interface AboutUsApi {

    @Operation(summary = "Публично: получить раздел AboutUs целиком")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    AboutUsResponse get();

    @Operation(summary = "Админ: обновить AboutUs (описание + список CompanyValues)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Раздел обновлён"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса"),
            @ApiResponse(responseCode = "401", description = "Не авторизован"),
            @ApiResponse(responseCode = "403", description = "Недостаточно прав")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    AboutUsResponse update(@Valid @RequestBody AboutUsUpdateRequest request);
}
