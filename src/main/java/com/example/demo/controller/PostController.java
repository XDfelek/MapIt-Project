package com.example.demo.controller;

import com.example.demo.model.dto.CreatePost;
import com.example.demo.model.dto.PostDTO;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/addpost")
    public void createPost(@RequestBody CreatePost request){
        //postService.createPost(request);
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/posts/{postID}")
    public PostDTO ShowPost(@PathVariable(name = "postID") Long postID ) {
        return postService.showPost(postID);
    }
}
