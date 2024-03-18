package com.example.fotomoto.Folder;

import com.example.fotomoto.Image.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class FolderDTO {
    private Long folderId;
    private String folderName;
    private int imageCount;
    private ImageDTO folderImages;
    // Other fields as needed

    public FolderDTO(Long folderId, String folderName, int imageCount, ImageDTO folderImages) {
        this.folderId = folderId;
        this.folderName = folderName;
        this.imageCount = imageCount;
        this.folderImages = folderImages;
    }
}
