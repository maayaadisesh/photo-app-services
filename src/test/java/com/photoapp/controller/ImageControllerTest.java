package com.photoapp.controller;

import com.photoapp.model.Image;
import com.photoapp.service.ImageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {

    @Mock
    ImageService imageService;

    @InjectMocks
    ImageController imgController;

    @Test
    public void getPhotosTest()
    {
        Mockito.when(imageService.getImages(1)).thenReturn(new ArrayList<Image>());
        List<Image> images = imgController.getPhotos(1);
        Assert.assertNotNull(images);
    }
}
