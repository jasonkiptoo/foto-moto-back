package com.example.fotomoto.Folder;

import com.example.fotomoto.Config.JwtService;
import com.example.fotomoto.Responses.ResponseHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        @GetMapping("get-all-folders")
    public ResponseEntity<Object> getAllFolders() {
        List<FolderEntity> folders = folderService.getAllFolders();
        return ResponseHandler.responseBuilder("Folders retrieved successfully", HttpStatus.OK,folders);
    }


}