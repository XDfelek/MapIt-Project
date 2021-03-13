package com.example.demo.repository;

import com.example.demo.model.dao.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileEntity, String> {

}
