package com.example.fotomoto.Folder;

import com.example.fotomoto.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class FolderServiceImp implements FolderService{

    private final FolderRepository folderRepo;
    @Override
    public FolderEntity addFolder(FolderEntity folder) {
        return folderRepo.save(folder);
    }

    @Override
    public List<FolderEntity> getAllFolders() {
      return folderRepo.findAll();
    }

    @Override
    public FolderEntity findById(Long folderId) {
        return folderRepo.findById(folderId).orElseThrow(()->new CustomException("No Folder with this ID"));

    }

//    @Override
//    public FolderEntity getFolderById(Long folderId) {
//        return folderRepo.findById(folderId).orElseThrow(()->new CustomException("No Folder with this ID"));
//    }

//    @Override
//    public boolean findById(Long folderId) {
//        return folderRepo.
//    }
}
