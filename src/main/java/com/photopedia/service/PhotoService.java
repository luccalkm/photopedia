package com.photopedia.service;

import com.photopedia.model.Photo;
import com.photopedia.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Optional<Photo> findById(Long id) {
        return photoRepository.findById(id);
    }

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deleteById(Long id) {
        photoRepository.deleteById(id);
    }
}
