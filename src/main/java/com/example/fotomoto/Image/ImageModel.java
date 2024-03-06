package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "images")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "folderId")
    private FolderEntity folderEntity;
    private String name;
    private String type;

    @Column(length = 50000000)
//    @Lob
    private byte[] picByte;




}
