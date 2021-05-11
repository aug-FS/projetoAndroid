package com.example.myfavoritephotos.model;

public class Image {
    Integer id;
    String title;
    String imageContent;

    public Image(Integer id, String title, String imageContent) {
        this.id = id;
        this.title = title;
        this.imageContent = imageContent;
    }

    public Image(String title, String imageContent) {
        this.title = title;
        this.imageContent = imageContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }
}
