package com.example.fotomoto.Folder;

import com.example.fotomoto.Config.JwtAuthenticationFilter;
import com.example.fotomoto.Config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ResponseEntity<?> addFolder(@RequestBody FolderEntity folder) {
        if (folderRepository.existsByFolderName(folder.getFolderName())) {
            String errorMessage = "Folder with duplicate name already exists";
            ErrorResponse errorResponse = new ErrorResponse(errorMessage);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(errorResponse);
        }

        folderService.addFolder(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
        @GetMapping("get-all-folders")
    public ResponseEntity<List<FolderEntity>> getAllFolders() {
        List<FolderEntity> folders = folderService.getAllFolders();
        return new ResponseEntity<>(folders, HttpStatus.OK);
    }


//    to be transfered to errorpackage
@Data
@AllArgsConstructor
private static class ErrorResponse {
    private String message;
}


}