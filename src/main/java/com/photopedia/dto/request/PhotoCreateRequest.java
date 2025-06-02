package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PhotoCreateRequest {
    @NotBlank(message = "Caption is required")
    private String caption;

    @NotBlank(message = "URL is required")
    private String url;

    @NotNull(message = "Album ID must be provided")
    private Long albumId;
}