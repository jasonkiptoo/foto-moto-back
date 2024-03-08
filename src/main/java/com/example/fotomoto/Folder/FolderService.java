package com.example.fotomoto.Folder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface FolderService {

  FolderEntity addFolder(FolderEntity folder);
  List<FolderEntity> getAllFolders();
  FolderEntity findById(Long folderId);
  FolderEntity UpdateFolder(FolderEntity folder);
//  List<FolderEntity> getRecentAccessedWithImages();

  List<FolderWithImagesDTO> getRecentAccessedWithImages();
}
