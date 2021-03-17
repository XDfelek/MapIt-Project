package com.example.demo.service;

import com.example.demo.ImageDataExtractor;
import com.example.demo.model.dao.CommentEntity;
import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dto.CreatePost;
import com.example.demo.model.dto.PostDTO;
import com.example.demo.repository.PostRepo;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    private final FileStorageServiceImpl fileStorageService;

    public void createPost(String fileName, String title, String description) throws IOException {
        PostEntity postEntity = new PostEntity();
        postEntity.setDate(LocalDateTime.now());
        postEntity.setTitle(title);
        String imagePath = fileStorageService.load(fileName).getFile().getPath();
        postEntity.setImagePath(imagePath);
        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();
        imageDataExtractor.getImageGPS(imagePath);
        postEntity.setDescription(description);
        postEntity.setImageLatitude(imageDataExtractor.getLatitude());
        postEntity.setImageLongitude(imageDataExtractor.getLongitude());

        postRepo.save(postEntity);

        //TODO if ImageLatitude == null or ImageLongitude == null , wezwać inną funkcję do wpisania danych ręcznie
    }

    /*public ShowAllPosts getAllPosts() {
        return ShowAllPosts.builder()
                .posts(postRepo.findAll().stream()
                        .map(postEntity -> ShowPost.builder()
                                .id(postEntity.getId())
                                .title(postEntity.getTitle())
                                .description(postEntity.getDescription())
                                .imagePath(postEntity.getImagePath())
                                .build())
                        .collect(Collectors.toList())).build();
    }*/

    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().stream()
                .map(postDTO -> PostDTO.builder()
                        .id(postDTO.getId())
                        .title(postDTO.getTitle())
                        .description(postDTO.getDescription())
                        .imagePath(postDTO.getImagePath())
                        .build())
                .collect(Collectors.toList());
    }




    public PostDTO showPost(Long id) {
        Optional<PostEntity> postEntity = postRepo.findById(id);

        if (postEntity.isPresent()) {
            PostDTO post = new PostDTO();
            post.setId(id);
            post.setTitle(postEntity.get().getTitle());
            post.setDescription((postEntity.get().getDescription()));
            post.setImagePath(postEntity.get().getImagePath());
            post.setLatitude(postEntity.get().getImageLatitude());
            post.setLongitude(postEntity.get().getImageLongitude());
            post.setCoordinates(postEntity.get().isImageCoordinatesAreReal());
            post.setVote(postEntity.get().getVotes());
            List<String> list = new ArrayList<>();
            for (CommentEntity comment : postEntity.get().getComments()) {
                String content = comment.getContent();
                list.add(content);
            }
            post.setComments(list);
            // post.setUserID();
            post.setDate(postEntity.get().getDate());

            return post;
        } else {
            throw new NoSuchElementException("We don't have this post");
        }
    }
}

