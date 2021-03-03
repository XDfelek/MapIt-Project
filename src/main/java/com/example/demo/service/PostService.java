package com.example.demo.service;

import com.example.demo.ImageDataExtractor;
import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dto.CreatePost;
import com.example.demo.repository.PostRepo;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

        public void createPost(CreatePost request) {
        PostEntity postEntity = new PostEntity();
        postEntity.setDate(LocalDateTime.now());
        postEntity.setTitle(request.getTitle());
        String imagePath = request.getImagePath();
        postEntity.setImagePath(imagePath);
        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();
        imageDataExtractor.getImageGPS(imagePath);
        postEntity.setDescription(request.getDescription());
        postEntity.setImageLatitude(imageDataExtractor.getLatitude());
        postEntity.setImageLongitude(imageDataExtractor.getLongitude());

        PostEntity savePost = postRepo.save(postEntity);
    }

    //    public void createPost(CreatePost request) {
//        PostEntity postEntity = new PostEntity();
//        postEntity.setDate(LocalDateTime.now());
//        postEntity.setTitle(request.getTitle());
//        postEntity.setImagePath(request.getImagePath());
//        postEntity.setDescription(request.getDescription());
//        postEntity.setImageLatitude(request.getImageLatitude());
//        postEntity.setImageLongitude(request.getImageLongitude());
//
//        PostEntity savePost = postRepo.save(postEntity);
//    }
}

