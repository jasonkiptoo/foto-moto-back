package com.example.fotomoto.Folder;

import com.example.fotomoto.Image.ImageDTO;
import com.example.fotomoto.Image.ImageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderDTO {
    private Long folderId;
    private String folderName;
//    private LocalDateTime lastAccessedTime;
    private int imageCount;
    // Other fields as needed
    private ImageDTO folderImages;

    public FolderDTO(Long folderId, String folderName, LocalDateTime lastAccessedTime, int imageCount, ImageDTO folderImages) {
        this.folderId = folderId;
        this.folderName = folderName;
//        this.lastAccessedTime = lastAccessedTime;
        this.imageCount = imageCount;

        this.folderImages=folderImages;

    }
}