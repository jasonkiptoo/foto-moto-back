package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ImageDTO {

    private Long id;
    private String imageName;
    private byte[] imageData;
//    private FolderEntity folder;
}
