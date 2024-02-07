package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderRepository;
import com.example.fotomoto.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/upload")
@Slf4j

public class ImageController {
    private final FolderRepository folderRepository;


    @PostMapping("/upload-images")
    public ResponseEntity<?> uploadImagesToFolder( String folderName, @RequestBody List<MultipartFile> images) {
        log.info("scdshj foldr {}", folderName);
        // Find the folder by name
        FolderEntity folder = folderRepository.findByFolderName(folderName).orElseThrow(() -> new UsernameNotFoundException("d"));
//        User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (folder == null) {
            String errorMessage = "Folder not found";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
        }

        // Process and save the images to the folder
        // You can use libraries like CommonsMultipartFile or MultipartFile to handle file uploads

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    to be transfered to errorpackage
    @Data
    @AllArgsConstructor
    private static class ErrorResponse {
        private String message;
    }

}
