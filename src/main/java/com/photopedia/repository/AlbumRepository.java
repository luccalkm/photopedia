package com.photopedia.repository;

import com.photopedia.model.Album;
import com.photopedia.model.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
