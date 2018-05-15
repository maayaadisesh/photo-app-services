package com.photoapp;


import junit.framework.Assert;
import org.junit.Test;

public class PhotoServiceApplicationTest {

    PhotoServiceApplication photoServiceApp = new PhotoServiceApplication();

    @Test
    public void restTemplateTest()
    {
        org.junit.Assert.assertNotNull(photoServiceApp.restTemplate());
    }
}
