package com.example.fotomoto.Image;

import lombok.Data;

@Data
public class ImageUploadRequest {
    private String imageName;
    private String imageUrl;

    // Getters and setters

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
