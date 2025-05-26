package com.example.app.controller.newentity.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NewEntityRs {
    private UUID id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalDateTime dateTime;
    private OffsetDateTime offsetDateTime;
    private UUID userId;
}
