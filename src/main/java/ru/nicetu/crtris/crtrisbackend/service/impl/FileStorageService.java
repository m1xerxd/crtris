package ru.nicetu.crtris.crtrisbackend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path root = Paths.get("uploads/reviews");

    public String storeReviewAvatar(MultipartFile file) {
        try {
            Files.createDirectories(root);

            String ext = getExt(file.getOriginalFilename());
            String filename = UUID.randomUUID() + (ext.isBlank() ? "" : "." + ext);

            Path target = root.resolve(filename).normalize();
            try (InputStream in = file.getInputStream()) {
                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
            }

            return "/assets/reviews/" + filename;

        } catch (IOException e) {
            throw new IllegalArgumentException("Не удалось сохранить файл", e);
        }
    }

    private String getExt(String originalName) {
        if (originalName == null) return "";
        int i = originalName.lastIndexOf('.');
        return (i > -1) ? originalName.substring(i + 1) : "";
    }
}

