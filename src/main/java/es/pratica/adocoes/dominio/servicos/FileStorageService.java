package es.pratica.adocoes.dominio.servicos;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final String[] ALLOWED_EXTENSIONS = {"jpg", "jpeg", "png", "gif", "webp"};

    public String storeFile(MultipartFile file) throws IOException {
        // Validate file
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Cannot store empty file");
        }

        // Validate file extension
        String originalFilename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename).toLowerCase();
        
        boolean isValidExtension = false;
        for (String allowedExt : ALLOWED_EXTENSIONS) {
            if (allowedExt.equals(extension)) {
                isValidExtension = true;
                break;
            }
        }
        
        if (!isValidExtension) {
            throw new IllegalArgumentException("File type not allowed. Allowed types: jpg, jpeg, png, gif, webp");
        }
        
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique filename
        String filename = UUID.randomUUID().toString() + "." + extension;
        Path targetLocation = uploadPath.resolve(filename);

        // Copy file to target location
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    public void deleteFile(String filename) throws IOException {
        if (filename != null && !filename.isEmpty()) {
            Path filePath = Paths.get(uploadDir).resolve(filename);
            Files.deleteIfExists(filePath);
        }
    }

    public Path getFilePath(String filename) {
        return Paths.get(uploadDir).resolve(filename);
    }

    public boolean fileExists(String filename) {
        if (filename == null || filename.isEmpty()) {
            return false;
        }
        return Files.exists(getFilePath(filename));
    }
}