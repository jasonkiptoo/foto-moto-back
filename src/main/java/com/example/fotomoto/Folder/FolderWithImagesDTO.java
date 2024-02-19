package com.example.fotomoto.Folder;


import lombok.Data;

import java.util.List;

@Data
public class FolderWithImagesDTO {
    private Long folderId;
    private String folderName;
//    private List<ImageDTO> images;

    // Constructors, getters, and setters

    public FolderWithImagesDTO() {
    }

}
