package com.photoapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photoapp.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${image.service.url}")
    String imageServiceUrl;

    Logger logger = LoggerFactory.getLogger(ImageService.class);

    public List<Image> getImages(int startId) {
        List<Image> images = new ArrayList<Image>();
        for (int i = startId; i <= startId + 10; i++) {
            try {
                Image image = restTemplate.getForObject(this.imageServiceUrl, Image.class, i);
                if(image!=null) {
                    images.add(image);
                }
            }catch(Exception e){
                logger.error("Error while fetching image:"+ startId, e);
            }
        }
        return images;
    }
}
