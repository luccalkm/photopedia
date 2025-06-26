package com.photopedia.service;

import com.photopedia.dto.AlbumDto;
import com.photopedia.dto.request.AlbumCreateRequest;
import com.photopedia.mapper.AlbumMapper;
import com.photopedia.mapper.PhotoMapper;
import com.photopedia.model.Album;
import com.photopedia.model.Photo;
import com.photopedia.model.Photographer;
import com.photopedia.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired private AlbumRepository albumRepository;
    @Autowired private PhotographerService photographerService;
    @Autowired private PhotoMapper photoMapper;
    @Autowired private AlbumMapper albumMapper;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    public AlbumDto createAlbum(AlbumCreateRequest request) {
        Album album = albumMapper.toEntity(request);
        Photographer photographer = photographerService.findById(request.getPhotographerId())
                .orElseThrow(() -> new IllegalArgumentException("Photographer not found"));

        album.setPhotographer(photographer);

        return albumMapper.toDto(albumRepository.save(album));
    }

    public AlbumDto updateAlbumWithPhotos(Long id, AlbumCreateRequest request) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        album.setTitle(request.getTitle());

        Photographer photographer = photographerService.findById(request.getPhotographerId())
                .orElseThrow(() -> new RuntimeException("Photographer not found"));
        album.setPhotographer(photographer);

        return albumMapper.toDto(albumRepository.save(album));
    }

    public AlbumDto toDto(Album album) {
        return albumMapper.toDto(album);
    }

    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
}