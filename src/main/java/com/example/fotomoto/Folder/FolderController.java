package com.example.fotomoto.Folder;

import com.example.fotomoto.Config.JwtAuthenticationFilter;
import com.example.fotomoto.Config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/folders")
@RequiredArgsConstructor
@Slf4j
public class FolderController {
    private final FolderService folderService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/add-folder")
    public ResponseEntity<FolderEntity> addFolder(@RequestBody FolderEntity folder, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        log.info("Received token: {}", token);

        if (token == null || token.isBlank() || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
//        extract useremail/name
        String jwt = token.substring(7).trim();
        final String userEmail = jwtService.extractUsername(jwt);
        log.info("userem as of noew {}" , userEmail);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        log.info("userem as of newnewneew {}" , userEmail);
        if (jwtService.isValidToken(jwt, userDetails)) {
            log.info("userem as of noewfsfsfsfsfs {}" , userEmail);
            folderService.addFolder(folder);
        }
        return new ResponseEntity<>(folder, HttpStatus.CREATED);

    }

    @GetMapping("get-all-folders")
    public ResponseEntity<List<FolderEntity>> getAllFolders() {
        List<FolderEntity> folders = folderService.getAllFolders();
        return new ResponseEntity<>(folders, HttpStatus.OK);
    }


}
