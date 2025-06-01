package com.photopedia.controller;

import com.photopedia.dto.PhotoDto;
import com.photopedia.dto.request.PhotoCreateRequest;
import com.photopedia.mapper.PhotoMapper;
import com.photopedia.model.Photo;
import com.photopedia.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
@Tag(
        name = "Photos / Fotos",
        description = "Manage photos added to albums / Gerencia as fotos adicionadas aos álbuns"
)
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoMapper photoMapper;

    @GetMapping
    @Operation(
            summary = "List all photos / Listar fotos",
            description = "Returns all photos stored in the system / Retorna todas as fotos cadastradas"
    )
    public List<PhotoDto> getAll() {
        return photoMapper.toDtoList(photoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get photo by ID / Buscar foto por ID",
            description = "Fetch a specific photo by its ID / Retorna os dados de uma foto específica"
    )
    public PhotoDto getById(@PathVariable Long id) {
        return photoService.findById(id)
                .map(photoMapper::toDto)
                .orElse(null);
    }

    @PostMapping
    @Operation(
            summary = "Create new photo / Criar foto",
            description = "Adds a new photo to an album / Cadastra uma nova foto no sistema"
    )
    public PhotoDto create(@RequestBody PhotoCreateRequest request) {
        Photo photo = photoMapper.toEntity(request);
        return photoMapper.toDto(photoService.save(photo));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update photo / Atualizar foto",
            description = "Updates an existing photo / Atualiza os dados de uma foto existente"
    )
    public PhotoDto update(@PathVariable Long id, @RequestBody PhotoCreateRequest request) {
        Photo updated = photoMapper.toEntity(request);
        updated.setId(id);
        return photoMapper.toDto(photoService.save(updated));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete photo / Remover foto",
            description = "Deletes a photo by its ID / Exclui uma foto pelo seu ID"
    )
    public void delete(@PathVariable Long id) {
        photoService.deleteById(id);
    }
}
