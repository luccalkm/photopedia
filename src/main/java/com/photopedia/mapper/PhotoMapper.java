package com.photopedia.mapper;

import com.photopedia.dto.PhotoDto;
import com.photopedia.dto.request.PhotoCreateRequest;
import com.photopedia.model.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
    List<PhotoDto> toDtoList(List<Photo> photos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "album", ignore = true)
    Photo toEntity(PhotoCreateRequest request);
}