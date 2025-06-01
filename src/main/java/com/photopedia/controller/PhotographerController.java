package com.photopedia.controller;


import com.photopedia.model.Photographer;
import com.photopedia.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @GetMapping
    public List<Photographer> getAll() {
        return photographerService.findAll();
    }

    @GetMapping("/{id}")
    public Photographer getById(@PathVariable Long id) {
        return photographerService.findById(id).orElse(null);
    }

    @PostMapping
    public Photographer create(@RequestBody Photographer photographer) {
        return photographerService.save(photographer);
    }

    @PutMapping("/{id}")
    public Photographer update(@PathVariable Long id, @RequestBody Photographer updated) {
        updated.setId(id);
        return photographerService.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photographerService.deleteById(id);
    }
}