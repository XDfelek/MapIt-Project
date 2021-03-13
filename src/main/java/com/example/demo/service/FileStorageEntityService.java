package com.example.demo.service;

import com.example.demo.model.dao.FileEntity;
import com.example.demo.repository.FileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageEntityService {

    @Autowired
    private FileRepo fileRepo;

    public FileEntity store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());

        return fileRepo.save(fileEntity);
    }

    public FileEntity getFile(String id) {
        return fileRepo.findById(id).get();
    }

    public Stream<FileEntity> getAllFiles() {
        return fileRepo.findAll().stream();
    }
}
