package com.example.demo.controller;

import com.example.demo.message.ResponseFile;
import com.example.demo.message.ResponseMessage;
import com.example.demo.model.dao.FileEntity;
import com.example.demo.service.FileStorageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
public class FileEntityController {

    @Autowired
    private FileStorageEntityService fileStorageEntityService;

    @PostMapping("/uploadEntity")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("fileEntity") MultipartFile fileEntity) {
        String message = "";
        try {
            fileStorageEntityService.store(fileEntity);

            message = "Dodano zdjecie do bazy danych pomyslnie! " + fileEntity.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Nie mozna było załadować zdjęcia do bazy danych! " + fileEntity.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/filesEntity")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileStorageEntityService.getAllFiles().map(fileEntity -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/filesEntity/")
                    .path(fileEntity.getId())
                    .toUriString();

            return new ResponseFile(
                    fileEntity.getName(),
                    fileDownloadUri,
                    fileEntity.getType(),
                    fileEntity.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/filesEntity/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileEntity fileEntity = fileStorageEntityService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .body(fileEntity.getData());
    }
}
