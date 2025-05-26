package com.example.app.controller.newentity.rq;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateNewEntityRq {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    private UUID userId;
}
