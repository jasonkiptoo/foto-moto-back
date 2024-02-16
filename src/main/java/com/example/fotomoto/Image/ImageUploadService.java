package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderRepository;
import com.example.fotomoto.Folder.FolderWithImagesDTO;
import com.example.fotomoto.Responses.ResponseClass;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface ImageUploadService {
//    private final ImageRepository imageRepository;
//    private final ModelMapper modelMapper;
//    private final FolderRepository folderRepository;

    ImageEntity uploadImages(MultipartFile file, FolderEntity folder) throws Exception;
    void saveImages(MultipartFile[] files) throws Exception;
    List<ImageEntity> getAllImages();











//    public FolderWithImagesDTO getFolderWithImages(Long folderId) {
//        FolderEntity folder = folderRepository.findById(folderId)
//                .orElseThrow(() -> new EntityNotFoundException("Folder not found with id: " + folderId));
//
//        List<ImageEntity> images = imageRepository.findByFolderId(folderId);
//        List<ImageDTO> imageDTOs = modelMapper.map(images, new TypeToken<List<ImageDTO>>() {}.getType());
//
//        FolderWithImagesDTO folderWithImages = new FolderWithImagesDTO();
//        folderWithImages.setFolderName(folder.getFolderName());
//        folderWithImages.setImages(imageDTOs);
//
//        return folderWithImages;
//    }
//
//    public ImageEntity uploadImage(MultipartFile[] files, FolderEntity folder) throws IOException {
//        if (files == null ) {
//            throw new IllegalArgumentException("File is empty or null");
//        }
//        for (MultipartFile file : files) {
//            String imageName = file.getOriginalFilename();
//            try {
//                file.transferTo(new File("/home/jayson/Documents/code/personal/DB/images" + imageName));
//                String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                        .path("/DB/")
//                        .path(imageName)
//                        .toUriString();
//                ResponseClass response = new ResponseClass(imageName,
//                        downloadUrl,
//                        file.getContentType(),
//                        file.getSize());
////                responseList.add(response);
//            } catch (Exception e) {
////                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            }
//        }
//
//
////        String fileName = StringUtils.cleanPath(files.getOriginalFilename());
////
////        // Create a new ImageEntity object and set its properties
////        ImageEntity image = new ImageEntity();
////        image.setImageName(fileName);
////        image.setImageData(files.getBytes()); // Read the bytes from the MultipartFile
////        image.setFolder(folder);
//
//        // Save the image entity to the database
//        return ResponseEntity.ok(HttpStatu)
//    }
//
//
//    public List<ImageDTO> getImagesByFolderId(Long folderId) {
//        List<ImageEntity> images = imageRepository.findByFolderId(folderId);
//        List<ImageDTO> imageDTOS = modelMapper.map(images, new TypeToken<List<ImageDTO>>() {}.getType());
//        return imageDTOS;
//    }
}
