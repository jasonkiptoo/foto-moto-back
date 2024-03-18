package com.example.fotomoto.Folder;

import com.example.fotomoto.Config.JwtService;
import com.example.fotomoto.Image.ImageDTO;
import com.example.fotomoto.Image.ImageModel;
import com.example.fotomoto.Image.ImageService;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("auth/folders")
@RequiredArgsConstructor
@Slf4j
public class FolderController {
    private final FolderService folderService;

    @PostMapping("/add-folder")
    public ResponseEntity<Object> addFolder(@RequestBody FolderEntity folder) {
        try {
            folderService.addFolder(folder);
            return ResponseHandler.responseBuilder("Folder added ", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    get  all existing folders
    @GetMapping("/get-all-folders")
    public ResponseEntity<Object> getAllFolders() {
        List<FolderEntity> folders = folderService.getAllFolders();
        return ResponseHandler.responseBuilder("Folders Retrieved Successfully", HttpStatus.OK, folders);
    }

    //    fetch recent accessed
    @GetMapping("/recently-accessed-folders")
    public ResponseEntity<Object> getRecentAccessedFoldersWithImages() {
        List<FolderDTO> folders = folderService.getRecentAccessedWithImages();
        return ResponseHandler.responseBuilder("Most Recent folders", HttpStatus.OK, folders);
    }
}


//}