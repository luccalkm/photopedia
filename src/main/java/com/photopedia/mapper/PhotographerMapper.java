package com.photopedia.mapper;

import com.photopedia.dto.PhotographerDto;
import com.photopedia.dto.request.PhotographerCreateRequest;
import com.photopedia.model.Photographer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotographerMapper {
    PhotographerDto toDto(Photographer photographer);
    List<PhotographerDto> toDtoList(List<Photographer> photographers);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "albums", ignore = true)
    Photographer toEntity(PhotographerCreateRequest request);
}