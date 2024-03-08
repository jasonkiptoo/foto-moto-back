package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderService;
import com.example.fotomoto.Folder.FolderWithImagesDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<FolderWithImagesDTO> getAllImages(Long folderId) {
        FolderEntity folder = folderService.findById(folderId);
        if (folder != null) {
            log.info("SCd found folderId {}");
            List<ImageModel> images= imageRepo.findAllByFolderEntity(folder);

            List<ImageModel> imageDTOs = new ArrayList<>();
            for (ImageModel image : images) {
                ImageDTO imageDTO = new ImageDTO(image.getImageId(),image.getName(), image.getType(), image.getPicByte());
                imageDTOs.add(imageDTO);
            }
//set recently accesde folder time on opening
            folder.setLastAccessedTime(LocalDateTime.now());
            folderService.UpdateFolder(folder);

            FolderWithImagesDTO folderWithImagesDTO= new FolderWithImagesDTO(folder, images);

            folderWithImagesDTO.setFolderId(folder.getFolderId());
            folderWithImagesDTO.setFolderName(folder.getFolderName());
            folderWithImagesDTO.setImages(imageDTOs);
            return List.of(folderWithImagesDTO);
//            return ResponseHandler.responseBuilder("",HttpStatus.OK,null);


        }
    return List.of();
    }
}
