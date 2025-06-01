package com.photopedia.mapper;

import com.photopedia.dto.AlbumDto;
import com.photopedia.dto.request.AlbumCreateRequest;
import com.photopedia.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumDto toDto(Album album);
    List<AlbumDto> toDtoList(List<Album> albums);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "photos", ignore = true)
    @Mapping(target = "photographer", ignore = true)
    Album toEntity(AlbumCreateRequest request);
}
