package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class AlbumCreateRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Photographer ID must be provided")
    private Long photographerId;

    private List<PhotoCreateRequest> photos;
}
