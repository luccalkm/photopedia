package com.photopedia.controller;


import com.photopedia.model.Album;
import com.photopedia.model.Photo;
import com.photopedia.service.AlbumService;
import com.photopedia.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> getAll() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public Photo getById(@PathVariable Long id) {
        return photoService.findById(id).orElse(null);
    }

    @PostMapping
    public Photo create(@RequestBody Photo photo) {
        return photoService.save(photo);
    }

    @PutMapping("/{id}")
    public Photo update(@PathVariable Long id, @RequestBody Photo updated) {
        updated.setId(id);
        return photoService.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photoService.deleteById(id);
    }
}