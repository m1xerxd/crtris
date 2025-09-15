package ru.nicetu.crtris.crtrisbackend.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.nicetu.crtris.crtrisbackend.security.JwtService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest req) {
        if ("admin".equals(req.getUsername()) && "admin".equals(req.getPassword())) {
            String token = jwtService.issueToken(req.getUsername(), "ADMIN");
            return new TokenResponse(token, "Bearer");
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials");
    }

    @Data
    public static class LoginRequest {
        @NotBlank private String username;
        @NotBlank private String password;
    }

    @Data
    public static class TokenResponse {
        private final String accessToken;
        private final String tokenType;
    }
}