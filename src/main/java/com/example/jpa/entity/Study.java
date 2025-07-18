package com.example.jpa.entity;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Study {
    private Long id;
    private String title;
    private String description;
    private int maxParticipants;
    private LocalDate deadline;
    private Long creatorId;
}
