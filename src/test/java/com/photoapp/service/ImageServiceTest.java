package com.photoapp.service;

import com.photoapp.model.Image;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    ImageService imgService;

    @Test
    public void getImagesTest()
    {
        Mockito.when(restTemplate.getForObject(null,Image.class,1)).thenReturn(new Image());
        List<Image> images = imgService.getImages(1);
        Assert.assertTrue(!(images.isEmpty()));
    }
    @Test
    public void getImages_nullResponse()
    {
        Mockito.when(restTemplate.getForObject(null,Image.class,1)).thenReturn(null);
        List<Image> images = imgService.getImages(1);
        Assert.assertTrue(!images.contains(null));
    }
    @Test
    public void getImages_ThrowsException()
    {
        Mockito.when(restTemplate.getForObject(null,Image.class,1)).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
        List<Image> images = imgService.getImages(1);
        Assert.assertTrue(!images.contains(null));
    }
    @Test
    public void getImages_VerifyData()
    {
        Image expectedImage = new Image();
        expectedImage.setId(1);
        expectedImage.setImageUrl("http://localhost:8080");
        expectedImage.setName("name 1");
        expectedImage.setCreatedAt(new Date(123456));
        Mockito.when(restTemplate.getForObject(null,Image.class,1)).thenReturn(expectedImage);
        List<Image> images = imgService.getImages(1);
        Assert.assertTrue(!images.contains(null));
        Image actualImage = images.get(0);
        Assert.assertEquals(1,actualImage.getId());
        Assert.assertEquals("http://localhost:8080", actualImage.getImageUrl());
        Assert.assertEquals("name 1", actualImage.getName());
        Assert.assertEquals(new Date(123456).getDate(), actualImage.getCreatedAt().getDate());

    }
}
