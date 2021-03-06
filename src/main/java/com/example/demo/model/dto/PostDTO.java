package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;

    private String  title;

    private String description;

    private String imagePath;

    private Double imageLatitude;

    private Double imageLongitude;

    private boolean coordinates;

    private int vote;

    private List<String> comments;

    private Long userID;

    private LocalDateTime date;
}
