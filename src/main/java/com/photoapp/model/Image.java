package com.photoapp.model;

import java.util.Date;

public class Image {

    private int id;
    private Date createdAt;
    private String name;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }


}
