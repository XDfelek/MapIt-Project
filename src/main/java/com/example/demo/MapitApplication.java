package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapitApplication {
    private final Logger logger = LoggerFactory.getLogger(MapitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MapitApplication.class, args);
        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();
        imageDataExtractor.getImageGPS(imageDataExtractor.imagePathTestWithGPS);
        imageDataExtractor.getImageGPS(imageDataExtractor.imagePathTestWithoutGPS);
    }

}
