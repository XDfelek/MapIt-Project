package com.example.demo.controller;

import com.example.demo.model.dto.CreatePost;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/addposts")
    public void createPost(@RequestBody CreatePost request){
        postService.createPost(request);
    }
}
