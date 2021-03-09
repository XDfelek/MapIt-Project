package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ShowAllPosts {

    private List<ShowPost> posts;
}
