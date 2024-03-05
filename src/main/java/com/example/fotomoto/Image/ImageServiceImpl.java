package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderService;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private final FolderService folderService;

    @Override
    public boolean findById(Long folderId) {
        return false;
    }

    @Override
    public void addImage(Long folderId, MultipartFile image) throws IOException {
        ImageModel imageModel = new ImageModel();
        imageModel.setFolderEntity(folderService.findById(folderId));
        imageModel.setName(image.getOriginalFilename());
        imageModel.setPicByte(image.getBytes());
        imageModel.setType(image.getContentType());
        imageRepo.save(imageModel);
    }

    @Override
    public List<ImageModel> getAllImages(Long folderId) {
        FolderEntity folder = folderService.findById(folderId);
        if (folder != null) {
            log.info("Fetching all images in folder {}", folderId);
//            return ResponseHandler.responseBuilder("all folder images here", HttpStatus.OK, folder);

                return imageRepo.findAllByFolderEntity(folder);
        }
        return null;
    }
}
