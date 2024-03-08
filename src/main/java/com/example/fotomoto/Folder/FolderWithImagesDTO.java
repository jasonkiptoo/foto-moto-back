package com.example.fotomoto.Folder;


import com.example.fotomoto.Image.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class FolderWithImagesDTO {
    private Long folderId;
    private String folderName;
    private List<ImageDTO> images;

    // Constructors, getters, and setters
    public FolderWithImagesDTO(FolderEntity folder) {
        this.folderId = folder.getFolderId();
        this.folderName = folder.getFolderName();
        this.images = images;
    }


    public Set<FolderWithImagesDTO> getFolderImages() {
        return null;
    }
}
