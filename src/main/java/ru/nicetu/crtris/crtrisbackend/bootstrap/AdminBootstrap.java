package ru.nicetu.crtris.crtrisbackend.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.nicetu.crtris.crtrisbackend.entity.User;
import ru.nicetu.crtris.crtrisbackend.entity.auth.Role;
import ru.nicetu.crtris.crtrisbackend.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminBootstrap implements ApplicationRunner {

    private final UserRepository userRepository;

    @Value("adminn@example.com")
    private String adminEmail;

    @Value("$2b$10$VabS/aSx1seC55y50G0wT.8AxZp8.0BoBc5bReJeJC/XMfBDfMVyC")
    private String adminPasswordHash;

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        userRepository.findByEmail(adminEmail).ifPresentOrElse(
                u -> log.info("Admin уже существует: {}", adminEmail),
                () -> {
                    User admin = User.builder()
                            .email(adminEmail)
                            .passwordHash(adminPasswordHash)
                            .role(Role.ADMIN)
                            .enabled(true)
                            .build();
                    userRepository.save(admin);
                    log.info("Admin создан: {}", adminEmail);
                }
        );
    }
}