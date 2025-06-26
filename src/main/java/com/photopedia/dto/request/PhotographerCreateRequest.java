package com.photopedia.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class PhotographerCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;

    private String email;
    private String bio;
    private String phone;
}