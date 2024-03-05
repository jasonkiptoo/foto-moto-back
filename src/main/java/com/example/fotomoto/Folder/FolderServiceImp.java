package com.example.fotomoto.Folder;

import com.example.fotomoto.CustomException;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class FolderServiceImp implements FolderService{

    private final FolderRepository folderRepo;
    @Override
    public FolderEntity addFolder(FolderEntity folder) {

        if(folderRepo.existsByFolderName(folder.getFolderName())){
            String message = "Folder with name exists" +folder.getFolderName() ;
            ResponseHandler.responseBuilder(message, HttpStatus.CONFLICT, null);
        }

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




}
