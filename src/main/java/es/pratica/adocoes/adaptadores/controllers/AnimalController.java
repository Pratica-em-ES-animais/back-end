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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateAnimalUC;
import es.pratica.adocoes.aplicacao.casosdeuso.DeleteAnimalUC;
import es.pratica.adocoes.aplicacao.casosdeuso.GetAnimalUC;
import es.pratica.adocoes.aplicacao.casosdeuso.UpdateAnimalStatusUC;
import es.pratica.adocoes.aplicacao.dtos.AnimalCreateDto;
import es.pratica.adocoes.aplicacao.dtos.AnimalResponseDto;
import es.pratica.adocoes.aplicacao.dtos.UpdateAnimalStatusDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.FileStorageServiceInterface;
import es.pratica.adocoes.aplicacao.dtos.UpdateAnimalStatusDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.FileStorageServiceInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/animal")
public class AnimalController {

    private final CreateAnimalUC createAnimalUC;
    private final GetAnimalUC getAnimalUC;
    private final UpdateAnimalStatusUC updateAnimalStatusUC;
    private final FileStorageServiceInterface fileStorageService;
    private final DeleteAnimalUC deleteAnimalUC;

    // -------------------------------------------------------
    // CREATE ANIMAL
    // -------------------------------------------------------
    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<?> createAnimal(
            @RequestBody @Valid AnimalCreateDto animalCreateDto, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            String erro = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(erro);
        }
        var createdAnimal = this.createAnimalUC.run(animalCreateDto);

        if (createdAnimal == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(createdAnimal, HttpStatus.CREATED);
    }

    // -------------------------------------------------------
    // UPLOAD PHOTO
    // -------------------------------------------------------
    @PostMapping(value = "/upload-photo/{id}", consumes = "multipart/form-data")
    @CrossOrigin("*")
    public ResponseEntity<Map<String, String>> uploadPhotoToAnimal(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) {

        try {
            // 1️⃣ Salva arquivo no disco
            String filename = fileStorageService.storeFile(file);

            // 2️⃣ Atualiza o animal com o nome da foto
            createAnimalUC.attachPhotoToAnimal(id, filename);

            // 3️⃣ Resposta pro front
            Map<String, String> response = new HashMap<>();
            response.put("filename", filename);
            response.put("url", "/api/animal/photo/" + filename);
            response.put("message", "Photo uploaded and attached successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    // -------------------------------------------------------
    // GET PHOTO
    // -------------------------------------------------------
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

    // -------------------------------------------------------
    // GET ALL PETS
    // -------------------------------------------------------
    @GetMapping("/pets")
    @CrossOrigin("*")
    public ResponseEntity<List<AnimalResponseDto>> getAll(){
        return new ResponseEntity<>(this.getAnimalUC.getAll(), HttpStatus.OK);
    }

    // -------------------------------------------------------
    // UPDATE STATUS
    // -------------------------------------------------------
    @PutMapping("/status")
    @CrossOrigin("*")
    public ResponseEntity<?> updateStatus(@RequestBody UpdateAnimalStatusDto dto) {

        var updated = updateAnimalStatusUC.run(dto);

        if (updated == null) {
            return new ResponseEntity<>("Animal not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // -------------------------------------------------------
    // DELETE ANIMAL (sem verificação de login no backend)
    // -------------------------------------------------------
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    public ResponseEntity<?> deleteAnimal(@PathVariable String id) {

        boolean deleted = deleteAnimalUC.run(id);

        if (!deleted) {
            return new ResponseEntity<>("Animal not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
