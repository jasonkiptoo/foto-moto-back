package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderRepository;
import com.example.fotomoto.Folder.FolderService;
import com.example.fotomoto.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("auth/images")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final ImageUploadService imageUploadService;
    private final FolderService folderService;

    @PostMapping("/upload/{folderId}")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
                                         @PathVariable Long folderId) {
        FolderEntity folder = folderService.getFolderById(folderId);
        if (folder == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            ImageEntity uploadedImage = imageUploadService.uploadImage(file, folder);
            return ResponseEntity.ok(uploadedImage);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/get-images/{folderId}")
    public ResponseEntity<?> getImagesByFolderId(@PathVariable Long folderId){
        try{
            List<ImageEntity> images = imageUploadService.getImagesByFolderId(folderId);
            if(images.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(images);
        }
        catch (Exception e){
            log.error("Error retrieving Images {}", folderId,e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
