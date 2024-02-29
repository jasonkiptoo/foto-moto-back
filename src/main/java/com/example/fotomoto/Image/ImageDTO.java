package com.example.fotomoto.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDTO {

    private int id;
    private String imageName;
    private byte[] picByte;
    private String imageType;

    public ImageDTO(String imageName, String imageType, byte[] picByte) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.picByte = picByte;
    }

}
