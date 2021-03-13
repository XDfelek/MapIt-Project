package com.example.demo.image.processing;


import com.example.demo.model.dao.PostEntity;
import lombok.extern.java.Log;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ImageStorage {
    public void saveToStorage(PostEntity postEntity){
        try {

            String pathDestination = "src/main/storage/" + LocalDate.now();

            File source = new File(postEntity.getImagePath());

            new File(pathDestination).mkdirs();

            File destination = new File(pathDestination);
            FileUtil.copyFile(source,destination);

        } catch (IOException ex){
            System.out.println("Error saving to server");
        }
    }
    public String getFromStorage(PostEntity postEntity){
        return "TODO";
    }
}
