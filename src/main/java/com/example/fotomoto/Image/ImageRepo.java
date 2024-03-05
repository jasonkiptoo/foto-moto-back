package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel, Long> {
    List<ImageModel> findAllByFolderEntity(FolderEntity folder);
//    List<ImageModel> saveAll(List<ImageModel> images);

}
