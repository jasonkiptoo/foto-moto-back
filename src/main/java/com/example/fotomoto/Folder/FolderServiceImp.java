package com.example.fotomoto.Folder;

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
        List<FolderEntity> folders = folderRepo.findAll();
        return folders;
    }

    @Override
    public FolderEntity getFolderById(Long folderId) {
        return folderRepo.findById(folderId).orElse(null);
    }
}
