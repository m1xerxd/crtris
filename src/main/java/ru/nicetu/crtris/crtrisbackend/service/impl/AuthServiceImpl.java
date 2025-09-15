package ru.nicetu.crtris.crtrisbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.nicetu.crtris.crtrisbackend.dto.request.LoginRequest;
import ru.nicetu.crtris.crtrisbackend.dto.response.CurrentUserResponse;
import ru.nicetu.crtris.crtrisbackend.dto.response.TokenResponse;
import ru.nicetu.crtris.crtrisbackend.entity.User;
import ru.nicetu.crtris.crtrisbackend.repository.UserRepository;
import ru.nicetu.crtris.crtrisbackend.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements ru.nicetu.crtris.crtrisbackend.service.AuthService {

    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    @Override
    public TokenResponse login(LoginRequest request) {
        User u = users.findByEmailIgnoreCase(request.username())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials"));

        if (!u.isEnabled() || !encoder.matches(request.password(), u.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bad credentials");
        }
        String token = jwt.generate(u.getEmail(), u.getRole().name());
        return new TokenResponse(token);
    }

    @Override
    public CurrentUserResponse current() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No auth");
        }
        String role = auth.getAuthorities().stream().findFirst()
                .map(a -> a.getAuthority().replaceFirst("^ROLE_", ""))
                .orElse("USER");
        return new CurrentUserResponse(auth.getName(), role);
    }
}