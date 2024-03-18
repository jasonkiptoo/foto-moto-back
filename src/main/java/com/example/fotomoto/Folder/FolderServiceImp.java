package com.example.fotomoto.Folder;

import com.example.fotomoto.CustomException;
import com.example.fotomoto.Image.ImageDTO;
import com.example.fotomoto.Image.ImageModel;
import com.example.fotomoto.Image.ImageRepo;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class FolderServiceImp implements FolderService {

    private final FolderRepository folderRepo;
    private final ImageRepo imageRepo;

    @Override
    public FolderEntity addFolder(FolderEntity folder) {
        if (folderRepo.existsByFolderName(folder.getFolderName())) {
            String message = "Folder with name exists" + folder.getFolderName();
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
        return folderRepo.findById(folderId).orElseThrow(() -> new CustomException("No Folder with this ID"));
    }

    @Override
    public FolderEntity UpdateFolder(FolderEntity folder) {
        return folderRepo.save(folder);
    }

    @Override
    public List<FolderDTO> getRecentAccessedWithImages() {
        List<FolderEntity> recentFolders = folderRepo.findTop4ByOrderByLastAccessedTimeDesc();
        return recentFolders.stream().map(folder -> {

            List<ImageModel> images = imageRepo.findAllByFolderEntity(folder);
            ImageDTO imageDTO=null;
            if(!images.isEmpty()){
                ImageModel firstImage= images.get(0);
                imageDTO= new ImageDTO(firstImage.getImageId(),firstImage.getType(),firstImage.getName(), firstImage.getPicByte());

            }
//            List<ImageDTO> imageDTOs = images.stream().map(imageModel -> new ImageDTO(imageModel.getImageId(), imageModel.getName(), imageModel.getType(), imageModel.getPicByte())).collect(Collectors.toList());
            return new FolderDTO(folder.getFolderId(), folder.getFolderName(), images.size(), imageDTO);
        }).collect(Collectors.toList());
    }

    @Override
    public FolderEntity getFolderById(Long folderId) {
        return null;
    }
}
