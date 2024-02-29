package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "images")
@Entity
@Data

public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    @ManyToOne
    private FolderEntity folderEntity;
    private String name;
    private String type;

    @Column(length = 50000000)
//    @Lob
    private byte[] picByte;


    public ImageModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }


}
