package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageName;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGBLOB")
    private byte[] imageData;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "folder_id", nullable = false)
    private FolderEntity folder;
}
