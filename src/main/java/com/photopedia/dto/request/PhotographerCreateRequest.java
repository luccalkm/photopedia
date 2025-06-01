package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class PhotographerCreateRequest {
    @NotBlank
    private String name;
    private List<AlbumCreateRequest> albums;
}
