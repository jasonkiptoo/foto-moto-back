package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderService;
import com.example.fotomoto.Responses.ResponseClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("auth/images")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final ImageUploadService imageUploadService;
    private final FolderService folderService;


//    upload single image to file system
    @PostMapping("/upload/{folderId}")
    public ResponseEntity<Object> uploadImage(

            @RequestParam("image") MultipartFile image, @PathVariable Long folderId) throws Exception {

        FolderEntity folder = folderService.getFolderById(folderId);

        if (folder == null) {
            return ResponseEntity.notFound().build();
//            log.info("noe folder {}"+folderId);
        }

//        for (MultipartFile image: images ){
//            ImageEntity att=imageUploadService.uploadImages(image);
//
//
//
//
//
//        }

                try {
            ImageEntity uploadedImage = imageUploadService.uploadImages(image, folder);
            return ResponseEntity.ok(uploadedImage);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


//        String imageName = image.getOriginalFilename();
//        try {
//            image.transferTo(new File("/home/jayson/Documents/code/personal/DB/images" + imageName));
//            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/download/")
//                    .path(imageName)
//                    .toUriString();
//            ResponseClass response = new ResponseClass(imageName,
//                    downloadUrl,
//                    image.getContentType(),
//                    image.getSize());
//            return ResponseEntity.ok(response);
//        }
//        finally {
//
//        }

    }
    @PostMapping("/multiple-image-upload")
    public ResponseEntity<List<ResponseClass>> MultipleImagesUpload(@RequestParam("files") MultipartFile[] images) throws Exception {
        FolderEntity folder =new FolderEntity();
        List<ResponseClass> responseList = new ArrayList<>();
        for (MultipartFile image: images ){
            ImageEntity att=imageUploadService.uploadImages(image, folder);
//            String imageName = image.getOriginalFilename();
            try{

                image.transferTo(new File("/home/jayson/Documents/code/personal/DB/" + att.getImageName()));
                String downloadUrl=ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(att.getImageName())
                        .toUriString();
                ResponseClass response = new ResponseClass(att.getImageName(),
                        downloadUrl,
                        image.getContentType(),
                        image.getSize());
                responseList.add(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        return ResponseEntity.ok(responseList);

}

//retrievv all images
//for retrieving  all the  files uploaded
@GetMapping("/all")
public ResponseEntity<List<ResponseClass>> getAllFiles() {
    List<ImageEntity> images = imageUploadService.getAllImages();
    List<ResponseClass> responseClasses = images.stream().map(image -> {

//        log.info("sdsdcs {}"+ image);
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/home/jayson/Documents/code/personal/DB/")
                .path(image.getImageType())
                .toUriString();
        return new ResponseClass(image.getImageName(),
                downloadURL,
                image.getImageType(),
                image.getImageData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.ok().body(responseClasses);
}



//    @PostMapping("/upload/{folderId}")
//    public ResponseEntity<?> handleMultipleFilesUpload(@RequestParam("files" ) MultipartFile[] files, @PathVariable Long folderId) {
//        FolderEntity folder = folderService.getFolderById(folderId);
//
//        if (folder == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        try {
//            ImageEntity uploadedImage = imageUploadService.uploadImage(files, folder);
//            return ResponseEntity.ok(uploadedImage);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }



//        List<ResponseClass> responseList = new ArrayList<>();
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
//                responseList.add(response);
//            } catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            }
//        }
//        return ResponseEntity.ok(responseList);
//    }
//    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
//                                         @PathVariable Long folderId) {
//        FolderEntity folder = folderService.getFolderById(folderId);
//        if (folder == null) {
//            return ResponseEntity.notFound().build();
//        }
//        try {
//            ImageEntity uploadedImage = imageUploadService.uploadImage(file, folder);
//            return ResponseEntity.ok(uploadedImage);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }



//    get all images
//    @GetMapping("get-all")
//    public ResponseEntity<List<ResponseClass>> getAllImages(@Pa){
//        List<Images> images =imageUploadService.geAllImages();
//    }

//    @GetMapping("/get-images/{folderId}")
//    public ResponseEntity<?> getImagesByFolderId(@PathVariable Long folderId) {
//        try {
//            List<ImageDTO> images = imageUploadService.getImagesByFolderId(folderId);
//            if (images.isEmpty()) {
//                return ResponseEntity.noContent().build();
//            }
////            FolderEntity folder =
//            return ResponseEntity.ok(images);
//        } catch (Exception e) {
//            log.error("Error retrieving Images {}", folderId, e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//    @GetMapping("/get-folder-with-images/{folderId}")
//    public ResponseEntity<?> getFolderWithImages(@PathVariable Long folderId) {
//        try {
//            FolderWithImagesDTO folderWithImages = imageUploadService.getFolderWithImages(folderId);
//            if (folderWithImages == null) {
//                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//            }
//            return ResponseEntity.ok(folderWithImages);
//        } catch (Exception e) {
//            // Log the error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

}
