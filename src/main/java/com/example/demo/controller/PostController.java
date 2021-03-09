package com.example.demo.controller;

import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dto.CreatePost;
import com.example.demo.model.dto.ShowAllPosts;
import com.example.demo.model.dto.ShowPost;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/addpost")
    public void createPost(@RequestBody CreatePost request){
        postService.createPost(request);
    }

    @GetMapping("/posts")
    public ResponseEntity getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/posts/{postID}")
    public ShowPost ShowPost(@PathVariable(name = "postID") Long postID ) {
        return postService.showPost(postID);
    }
}
