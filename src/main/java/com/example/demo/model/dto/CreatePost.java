package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePost {

    private String title;

    private LocalDateTime date;

    private String imagePath;

    private String description;

    private Double imageLatitude;

    private Double imageLongitude;

}
