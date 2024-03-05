package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private  final FolderService folderService;

    @Override
    public boolean findById(Long folderId) {
        return false;
    }

    @Override
    public void addImage(Long folderId, MultipartFile image) throws IOException {

        ImageModel  imageModel = new ImageModel();
//        imageModel.setFolderEntity();
        imageModel.setFolderEntity(folderService.findById(folderId));
        imageModel.setName(image.getOriginalFilename());
        imageModel.setPicByte(image.getBytes());
        imageModel.setType(image.getContentType());
        imageRepo.save(imageModel);
    }

}
