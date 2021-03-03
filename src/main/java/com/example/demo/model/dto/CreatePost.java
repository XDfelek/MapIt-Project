package com.example.demo.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePost {

    private String title;

    private String imagePath;

    private String description;

    private Double imageLatitude;

    private Double imageLongitude;

}
