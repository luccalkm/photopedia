package com.photopedia.controller;

import com.photopedia.dto.AlbumDto;
import com.photopedia.dto.request.AlbumCreateRequest;
import com.photopedia.mapper.AlbumMapper;
import com.photopedia.model.Album;
import com.photopedia.model.Photographer;
import com.photopedia.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@Tag(
        name = "Albums / Álbuns",
        description = "Manage photo albums belonging to photographers / Gerencia os álbuns de fotos dos fotógrafos"
)
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumMapper albumMapper;

    @GetMapping
    @Operation(
            summary = "List all albums / Listar álbuns",
            description = "Returns all photo albums in the system / Retorna todos os álbuns cadastrados"
    )
    public List<AlbumDto> getAll() {
        return albumService.findAll().stream().map(albumService::toDto).toList();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get album by ID / Buscar álbum por ID",
            description = "Fetch a specific album by its ID / Retorna os dados de um álbum específico"
    )
    public AlbumDto getById(@PathVariable Long id) {
        return albumService.findById(id)
                .map(albumService::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found"));
    }

    @PostMapping
    @Operation(
            summary = "Create new album / Criar álbum",
            description = "Registers a new album under a photographer / Cadastra um novo álbum"
    )
    public AlbumDto create(@RequestBody AlbumCreateRequest request) {
        return albumService.createAlbumWithPhotos(request);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Update album / Atualizar álbum",
            description = "Updates an existing album’s data / Atualiza os dados de um álbum"
    )
    public AlbumDto update(@PathVariable Long id, @RequestBody AlbumCreateRequest request) {
        return albumService.updateAlbumWithPhotos(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete album / Remover álbum",
            description = "Deletes an album by its ID / Exclui um álbum pelo seu ID"
    )
    public void delete(@PathVariable Long id) {
        albumService.deleteById(id);
    }
}
