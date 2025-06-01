package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhotoCreateRequest {
    @NotBlank
    private String caption;

    @NotBlank
    private String url;
}
