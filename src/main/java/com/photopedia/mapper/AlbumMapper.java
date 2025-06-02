package com.photopedia.mapper;

import com.photopedia.dto.AlbumDto;
import com.photopedia.dto.request.AlbumCreateRequest;
import com.photopedia.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PhotoMapper.class })
public interface AlbumMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "photographer", ignore = true)
    Album toEntity(AlbumCreateRequest request);

    AlbumDto toDto(Album album);
    List<AlbumDto> toDtoList(List<Album> albums);
}