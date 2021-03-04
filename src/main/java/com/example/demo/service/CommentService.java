package com.example.demo.service;

import com.example.demo.model.dao.CommentEntity;
import com.example.demo.model.dto.CreateComment;
import com.example.demo.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;

    public void createComment(CreateComment request) {
        CommentEntity commentEntity= new CommentEntity();
        commentEntity.setContent(request.getContent());
        commentEntity.setDate(LocalDate.now());

        CommentEntity saveComment = commentRepo.save(commentEntity);
    }
}
