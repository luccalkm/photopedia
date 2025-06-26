package com.photopedia.controller;

import com.photopedia.dto.PhotographerDto;
import com.photopedia.dto.request.PhotographerCreateRequest;
import com.photopedia.mapper.PhotographerMapper;
import com.photopedia.model.Photographer;
import com.photopedia.service.PhotographerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
@Tag(name = "Photographers / Fotógrafos", description = "Manage professional photographers and their albums / Gerencia fotógrafos profissionais e seus álbuns")
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @Autowired
    private PhotographerMapper photographerMapper;

    @GetMapping
    @Operation(summary = "List all photographers / Listar fotógrafos", description = "Returns all photographers in the system / Retorna todos os fotógrafos cadastrados")
    public List<PhotographerDto> getAll() {
        List<Photographer> photographers = photographerService.findAll();
        List<PhotographerDto> photographerDtos = photographerMapper.toDtoList(photographers);
        return photographerDtos;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get photographer by ID / Buscar fotógrafo por ID", description = "Fetch a specific photographer by its ID / Retorna os dados de um fotógrafo específico")
    public PhotographerDto getById(@PathVariable Long id) {
        return photographerService.findById(id).map(photographerMapper::toDto).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Create new photographer / Criar fotógrafo", description = "Registers a new photographer in the system / Cadastra um novo fotógrafo")
    public PhotographerDto create(@RequestBody PhotographerCreateRequest request) {
        var photographer = photographerMapper.toEntity(request);
        return photographerMapper.toDto(photographerService.save(photographer));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update photographer / Atualizar fotógrafo", description = "Updates an existing photographer’s details / Atualiza os dados de um fotógrafo")
    public PhotographerDto update(@PathVariable Long id, @RequestBody PhotographerCreateRequest request) {
        Photographer existing = photographerService.findById(id)
                .orElseThrow(() -> new RuntimeException("Photographer not found"));
        photographerMapper.updatePhotographerFromDto(request, existing);
        return photographerMapper.toDto(photographerService.save(existing));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete photographer / Remover fotógrafo", description = "Deletes a photographer by ID / Exclui um fotógrafo pelo seu ID")
    public void delete(@PathVariable Long id) {
        photographerService.deleteById(id);
    }
}
