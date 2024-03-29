package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderRepository;
import com.example.fotomoto.Folder.FolderService;
import com.example.fotomoto.Folder.FolderWithImagesDTO;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/add-images-to-folder/{folderId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addImagesToFolder(
            @PathVariable Long folderId,
            @RequestPart("imageFiles") MultipartFile image) {
        try {
            imageService.addImage(folderId, image);
            return ResponseHandler.responseBuilder("", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    //    geet images in a folder
    @GetMapping("/get-images/{folderId}")
    public ResponseEntity<?> getFolderImages(@PathVariable Long folderId) {

        try {
            List<FolderWithImagesDTO> images = imageService.getAllImages(folderId);
            return ResponseHandler.responseBuilder("Images in the folder retrieved successfully", HttpStatus.OK, images);
        } catch (Exception e) {
            return new ResponseEntity<>("Error getting images", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
