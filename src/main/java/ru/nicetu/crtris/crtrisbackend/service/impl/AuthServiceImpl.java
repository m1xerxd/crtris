package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.repository.UserRepository;
import ru.nicetu.crtris.crtrisbackend.security.JwtService;
import ru.nicetu.crtris.crtrisbackend.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    @Override
    public String login(LoginRequest request) {
        var u = users.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialsException("Неверные учётные данные"));

        if (!u.isEnabled() || !encoder.matches(request.password(), u.getPasswordHash())) {
            throw new BadCredentialsException("Неверные учётные данные");
        }
        return jwt.generate(u.getEmail(), u.getRole().name());
    }
}