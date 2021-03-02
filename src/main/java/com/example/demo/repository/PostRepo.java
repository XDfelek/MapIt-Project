package com.example.demo.repository;

import com.example.demo.model.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
}
