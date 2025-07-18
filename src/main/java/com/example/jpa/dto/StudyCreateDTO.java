package com.example.jpa.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
public class StudyCreateDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Integer maxParticipants;

    @NotNull
    private LocalDate deadline;
}
