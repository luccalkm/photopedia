package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class AlbumCreateRequest {
    @NotBlank
    private String title;
    private List<PhotoCreateRequest> photos;
}
