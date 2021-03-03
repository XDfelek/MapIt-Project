package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageDataExtractor {
    private final Logger logger = LoggerFactory.getLogger(MapitApplication.class);

    public String imagePathTest = "D:\\GIT Repozytorium\\MapIt Project\\src\\main\\resources\\photos\\IMG_20190224_155957.jpg";

    public double[] getImageGPS(String imagePath){
        javaxt.io.Image image = new javaxt.io.Image(imagePath);
        double[] gps = image.getGPSCoordinate();
        double lat = gps[1];
        double leng = gps[0];
        logger.info("latitude = " + lat + " , longitude = " + leng);
        return gps;
    }
}
