package com.example.demo.controller;

import com.example.demo.model.dto.CreatePost;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/addpost")
    public void createPost(@RequestBody CreatePost request){
        postService.createPost(request);
    }
}
