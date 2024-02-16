package com.example.fotomoto.Folder;


import com.example.fotomoto.Image.ImageDTO;
import lombok.Data;

import java.util.List;

@Data
public class FolderWithImagesDTO {
    private Long folderId;
    private String folderName;
    private List<ImageDTO> images;

    // Constructors, getters, and setters

    public FolderWithImagesDTO() {
    }
    public FolderWithImagesDTO(Long folderId,String folderName, List<ImageDTO> images) {
        this.folderId=folderId;
        this.folderName = folderName;
        this.images = images;
    }

}
