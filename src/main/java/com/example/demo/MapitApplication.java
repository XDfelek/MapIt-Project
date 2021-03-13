package com.example.demo;

import com.example.demo.service.FileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;

@SpringBootApplication
public class MapitApplication implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(MapitApplication.class);
    @Resource
    FileStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(MapitApplication.class, args);
        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();
        imageDataExtractor.getImageGPS(imageDataExtractor.imagePathTestWithGPS);
        imageDataExtractor.getImageGPS(imageDataExtractor.imagePathTestWithoutGPS);
    }


    @Override
    public void run(String... args) throws Exception {
            storageService.deleteAll();
            storageService.init();
    }
}
