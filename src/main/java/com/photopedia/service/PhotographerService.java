package com.photopedia.service;

import com.photopedia.model.Photographer;
import com.photopedia.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotographerService {

    @Autowired
    private PhotographerRepository photographerRepository;

    public List<Photographer> findAll() {
        return photographerRepository.findAll();
    }

    public Optional<Photographer> findById(Long id) {
        return photographerRepository.findById(id);
    }

    public Photographer save(Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    public void deleteById(Long id) {
        photographerRepository.deleteById(id);
    }
}
