package com.example.demo.service;

import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dto.CreatePost;
import com.example.demo.repository.PostRepo;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public void createPost(CreatePost request) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(request.getTitle());
        postEntity.setImagePath(request.getImagePath());
        postEntity.setDescription(request.getDescription());
        postEntity.setImageLatitude(request.getImageLatitude());
        postEntity.setImageLongitude(request.getImageLongitude());

        PostEntity savePost = postRepo.save(postEntity);
    }
}
