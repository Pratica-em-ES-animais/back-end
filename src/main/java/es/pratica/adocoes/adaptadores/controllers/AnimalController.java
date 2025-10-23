package es.pratica.adocoes.adaptadores.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateAnimalUC;
import es.pratica.adocoes.aplicacao.casosdeuso.GetAnimalUC;
import es.pratica.adocoes.aplicacao.dtos.AnimalDto;
import es.pratica.adocoes.dominio.servicos.FileStorageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/animal")
public class AnimalController {
    private final CreateAnimalUC createAnimalUC;
    private final GetAnimalUC getAnimalUC;
    private final FileStorageService fileStorageService;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody @Valid AnimalDto animalDto){
        if(this.createAnimalUC.run(animalDto) == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(animalDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/upload-photo", consumes = "multipart/form-data")
    @CrossOrigin("*")
    public ResponseEntity<Map<String, String>> uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            String filename = fileStorageService.storeFile(file);
            
            Map<String, String> response = new HashMap<>();
            response.put("filename", filename);
            response.put("url", "/api/animal/photo/" + filename);
            response.put("message", "Photo uploaded successfully");
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to upload file: " + e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/photo/{filename}")
    @CrossOrigin("*")
    public ResponseEntity<Resource> getPhoto(@PathVariable String filename) {
        try {
            Resource resource = new UrlResource(fileStorageService.getFilePath(filename).toUri());
            
            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(fileStorageService.getFilePath(filename));
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }
                
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
                        .body(resource);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pets")
    @CrossOrigin("*")
    public ResponseEntity<List<AnimalDto>> getAll(){
        return new ResponseEntity<>(this.getAnimalUC.getAll(), HttpStatus.OK);
    }
}
