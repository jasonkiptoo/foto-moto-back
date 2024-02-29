package com.example.fotomoto.Folder;

import com.example.fotomoto.Config.JwtService;
import com.example.fotomoto.Image.ImageModel;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("auth/folders")
@RequiredArgsConstructor
@Slf4j
public class FolderController {
    private final FolderService folderService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final FolderRepository folderRepository;

    @PostMapping("/add-folder")
    public ResponseEntity<Object> addFolder(@RequestBody FolderEntity folder) {
        if (folderRepository.existsByFolderName(folder.getFolderName())) {
            String errorMessage = "Folder with duplicate name already exists";
            return ResponseHandler.responseBuilder(errorMessage,HttpStatus.CONFLICT,folder);
        }
        folderService.addFolder(folder);
        return ResponseHandler.responseBuilder("Folder Created Succcessfully", HttpStatus.OK, folder);
    }
//        @GetMapping("/get-all-folders")
//        public ResponseEntity<Object> getAllFolders() {
//        List<FolderEntity> folders = folderService.getAllFolders();
//        return ResponseHandler.responseBuilder("Folders retrieved successfully", HttpStatus.OK,folders);
//    }
//    @PostMapping(value = "/{folderId}/add-images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> addImagesToFolder(
//            @PathVariable Long folderId,
//            @RequestPart("imageFiles") MultipartFile[] files) {
//        try {
//            FolderEntity folder = folderService.getFolderById(folderId);
//            if (folder == null) {
//                String errorMessage = "Folder not found with id: " + folderId;
//                return ResponseHandler.responseBuilder(errorMessage, HttpStatus.NOT_FOUND, null);
//            }
//
//            Set<ImageModel> images = uploadImage(files);
//            folder.getFolderImages().addAll(images);
//            folderService.updateFolder(folder);
//
//            return ResponseHandler.responseBuilder("Images added to folder successfully", HttpStatus.OK, folder);
//        } catch (Exception e) {
//            log.error("Error adding images to folder", e);
//            return ResponseHandler.responseBuilder("Error adding images to folder", HttpStatus.INTERNAL_SERVER_ERROR, null);
//        }
//    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels =new HashSet<>();

        for (MultipartFile files: multipartFiles){
            ImageModel imageModel= new ImageModel(
                    files.getOriginalFilename(),
                    files.getContentType(),
                    files.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
//get all folders in the db
//    @GetMapping("/get-all-folders")
//    public ResponseEntity<Object> getAllFolders() {
//        try {
//            List<FolderEntity> folders = folderService.getAllFolders();
//            return ResponseHandler.responseBuilder("Folders retrieved successfully", HttpStatus.OK, folders);
//        } catch (Exception e) {
//            log.error("Error retrieving folders", e);
//            return ResponseHandler.responseBuilder("Error retrieving folders", HttpStatus.INTERNAL_SERVER_ERROR, null);
//        }
//    }
//    get images in a folder
//    @GetMapping("get-images-in-folder/{folderId}")
//    public ResponseEntity<Object> getImagesByFolderId(@PathVariable Long folderId){
//        try{
//            FolderEntity folderEntity =folderService.getFolderById(folderId);
//            if(folderEntity==null){
//                String errorMessage= "Folder Id not found"+folderId;
//                return ResponseHandler.responseBuilder(errorMessage, HttpStatus.NOT_FOUND, null);
//            }
//            folderEntity.setLastAccessedTime(LocalDateTime.now());
//            folderService.updateFolder(folderEntity);
//
//            Set<ImageModel> images = folderEntity.getFolderImages();
//            return ResponseHandler.responseBuilder("Images Retrieved", HttpStatus.OK, images);
//        }
//        catch (Exception e){
//            return ResponseHandler.responseBuilder("Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
//        }
//    }

//    get last accesed folder

//    @GetMapping("/last-accessed-folders")
//    public ResponseEntity<Object> getLastAccessedFolders() {
//        try {
//            List<FolderDTO> folderDTOs = folderService.getLastAccessedFolders();
//            return ResponseHandler.responseBuilder("Fetched recent images", HttpStatus.OK, folderDTOs);
//        } catch (Exception e) {
//            return ResponseHandler.responseBuilder("Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
//        }
    }






//}