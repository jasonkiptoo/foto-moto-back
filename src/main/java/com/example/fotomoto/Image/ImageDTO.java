package com.example.fotomoto.Image;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageDTO  {

    private Long imageId;
    private String imageName;
    private byte[] picByte;
    private String imageType;


    public ImageDTO(Long imageId, String imageName, String imageType, byte[] picByte) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageType = imageType;
        this.picByte = picByte;
    }

}
