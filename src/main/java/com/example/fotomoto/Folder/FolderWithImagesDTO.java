package com.example.fotomoto.Folder;


import com.example.fotomoto.Image.ImageDTO;
import com.example.fotomoto.Image.ImageModel;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class FolderWithImagesDTO {
    private Long folderId;
    private String folderName;
    private List<ImageDTO> images;

    // Constructors, getters, and setters

    public FolderWithImagesDTO() {
    }

    public Set<ImageModel> getFolderImages() {
        return null;
    }
}
