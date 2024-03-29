package com.example.fotomoto.Folder;

import com.example.fotomoto.Image.ImageModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "folders")
public class FolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long folderId;

    @Column(unique = true, nullable = false)
    private String folderName;


    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Column(name = "folder_type")
    private String folderType = "";
    @Column(name = "folder_description")
    private String folderDescription = "";
    @Column(name = "folder_owner")
    private String folderOwner = "";

    @Column(name = "last_accessed_time")
    private LocalDateTime lastAccessedTime;

//    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
//    private List<ImageModel> folderImages;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "folderId")
//    private Set<ImageModel> folderImages;


//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "folder_images",
//            joinColumns = {
//                    @JoinColumn(name = "folder_id")
//            },
//
//            inverseJoinColumns = {
//                    @JoinColumn(name = "image_id")
//            }
//    )

}