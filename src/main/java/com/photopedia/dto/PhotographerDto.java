package com.photopedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotographerDto {
    private Long Id;
    private String name;

    private String email;
    private String bio;
    private String phone;
    private List<AlbumDto> albums;
}
