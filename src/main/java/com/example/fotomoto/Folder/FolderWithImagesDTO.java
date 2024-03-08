package com.example.fotomoto.Folder;


import com.example.fotomoto.Image.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class FolderWithImagesDTO {
    private Long folderId;
    private String folderName;
    private List<ImageModel> images;

    // Constructors, getters, and setters

    public FolderWithImagesDTO(FolderEntity folder, List<ImageModel> images) {
        this.folderId = folder.getFolderId();
        this.folderName = folder.getFolderName();
        this.images = images;
    }


    public Set<FolderWithImagesDTO> getFolderImages() {
        return null;
    }
}
