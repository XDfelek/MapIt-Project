package com.example.demo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ImageDataExtractor {
    private final Logger logger = LoggerFactory.getLogger(MapitApplication.class);

    public Double latitude;
    public Double longitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String imagePathTestWithGPS = "src/main/resources/photos/IMG_20190224_155957.jpg";
    public String imagePathTestWithoutGPS = "src/main/resources/photos/15380582_377815685889730_2247397068673265016_n.jpg";

    public double[] getImageGPS(String imagePath){
        javaxt.io.Image image = new javaxt.io.Image(imagePath);
        double[] gps = image.getGPSCoordinate();
        if(gps != null) {
            setLatitude(gps[1]);
            setLongitude(gps[0]);
            logger.info("latitude = " + latitude + " , longitude = " + longitude);
            return gps;
        }else{
            double[] fakeGps = {0.0 ,0.0};
            logger.info("latitude = " + fakeGps[0] + " , longitude = " + fakeGps[1]);
            return fakeGps;
        }


    }
}
