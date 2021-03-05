package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowPost {

    private Long id;

    private String  title;

    private String description;

    private String imagePath;

    private Double latitude;

    private Double longitude;

    private boolean coordinates;

    private List<String> vote;

    private List<String> comments;

    private Long userID;

    private LocalDateTime date;
}
