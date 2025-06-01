package com.photopedia.controller;


import com.photopedia.model.Album;
import com.photopedia.model.Photographer;
import com.photopedia.service.AlbumService;
import com.photopedia.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAll() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return albumService.findById(id).orElse(null);
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return albumService.save(album);
    }

    @PutMapping("/{id}")
    public Album update(@PathVariable Long id, @RequestBody Album updated) {
        updated.setId(id);
        return albumService.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumService.deleteById(id);
    }
}