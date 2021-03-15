package com.example.demo.service;

import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dto.CreatePost;
import com.example.demo.model.dto.PostDTO;
import com.example.demo.repository.PostRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @Mock
    private PostRepo postRepo;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreatePost() {
        postService.createPost(createPost());

    }

    @Test
    void shouldGetAllPost() {

        when(postRepo.findAll()).thenReturn(List.of(postEntity()));
       List<PostDTO> posts =  postService.getAllPosts();
       Assertions.assertEquals(1, posts.size());
       Assertions.assertEquals("Post Name", posts.get(0).getTitle());

    }

    @Test
    void shouldShowPost() {

        when(postRepo.findById(1L)).thenReturn(Optional.of(postEntity()));
        PostDTO postDTO =  postService.showPost(1L);
        Assertions.assertEquals(1L, postDTO.getId());
        Assertions.assertEquals("Post Description", postDTO.getDescription());
        Assertions.assertEquals(true, postDTO.isCoordinates());
    }


    private PostEntity postEntity() {
        PostEntity postEntity = new PostEntity();

        postEntity.setDate(LocalDateTime.now());
        postEntity.setDescription("Post Description");
        postEntity.setId(1L);
        postEntity.setImagePath("src/test/resources/photos/15380582_377815685889730_2247397068673265016_n.jpg");
        postEntity.setTitle("Post Name");
        postEntity.setImageLatitude(Double.valueOf("52.231936545664844"));
        postEntity.setImageLongitude(Double.valueOf("21.006477796033575"));
        postEntity.setImageCoordinatesAreReal(true);
        postEntity.setVotes(Collections.emptyList());
        postEntity.setComments(Collections.emptyList());

        return postEntity;
    }

    private CreatePost createPost() {
        return CreatePost.builder()
                .imageLongitude(Double.valueOf("21.006477796033575"))
                .imageLatitude(Double.valueOf("52.231936545664844"))
                .date(LocalDateTime.now())
                .imagePath("src/test/resources/photos/IMG_20190224_155957.jpg")
                .description("Post Description")
                .title("Post Name")
                .build();

    }
}



