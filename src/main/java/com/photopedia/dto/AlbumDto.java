package com.photopedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {
    private Long id;
    private String title;
    private List<PhotoDto> photos;
}
