package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ImageEntity {

    @Id
    private Long Id;

    @ManyToOne
    @JoinColumn(name="folder_id")
    private FolderEntity folder;
}
