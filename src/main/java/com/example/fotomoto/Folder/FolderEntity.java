package com.example.fotomoto.Folder;

import com.example.fotomoto.Image.ImageModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="folders")
public class FolderEntity {





    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long folderId;

    @Column(unique = true,nullable = false)
    private String folderName;

    public Long getId() {
        return folderId;
    }

    public void setId(Long id) {
        this.folderId = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }


@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name="folder_images",
joinColumns = {
        @JoinColumn(name = "folder_id")
},

inverseJoinColumns = {
        @JoinColumn(name = "image_id")
}
)


    private Set<ImageModel> folderImages    ;


//    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
//    private List<ImageEntity>images;
//    public List<ImageEntity> getImages() {
//        return images;
//    }
}