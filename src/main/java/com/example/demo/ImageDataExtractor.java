package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ImageDataExtractor {
    private final Logger logger = LoggerFactory.getLogger(MapitApplication.class);

    public String imagePathTestWithGPS = "src/main/resources/photos/IMG_20190224_155957.jpg";
    public String imagePathTestWithoutGPS = "src/main/resources/photos/15380582_377815685889730_2247397068673265016_n.jpg";

    public double[] getImageGPS(String imagePath){
        javaxt.io.Image image = new javaxt.io.Image(imagePath);
        double[] gps = image.getGPSCoordinate();
        if(gps != null) {
            double lat = gps[1];
            double leng = gps[0];
            logger.info("latitude = " + lat + " , longitude = " + leng);
            return gps;
        }else{
            double[] fakeGps = {0.0 ,0.0};
            logger.info("latitude = " + fakeGps[0] + " , longitude = " + fakeGps[1]);
            return fakeGps;
        }


    }
}
