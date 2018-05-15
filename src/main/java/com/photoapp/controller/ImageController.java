package com.photoapp.controller;

import com.photoapp.model.Image;
import com.photoapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

        @GetMapping(path = { "/images" })
        @Produces(value = "application/json")
        @ResponseBody()
        public List<Image> getPhotos(@RequestParam("startId") int startId) {
            return imageService.getImages(startId);
        }
}
