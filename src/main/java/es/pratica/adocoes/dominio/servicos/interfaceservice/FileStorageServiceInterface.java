package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageServiceInterface {
    public String storeFile(MultipartFile file) throws IOException;
    public void deleteFile(String filename) throws IOException;
    public Path getFilePath(String filename);
    public boolean fileExists(String filename);
}
