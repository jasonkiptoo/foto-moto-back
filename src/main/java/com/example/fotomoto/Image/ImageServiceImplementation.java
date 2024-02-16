package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.mysql.cj.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImplementation implements ImageUploadService  {

    private  final ImageRepository imageRepository;

    @Override
    public ImageEntity uploadImages(MultipartFile image, FolderEntity folder) throws Exception {
        String imageName = image.getOriginalFilename();
        try {
//            if (imageName.contains("..")) {
//                throw new Exception("Invalid Image Name" + imageName);
//            }
//            if (image.getBytes().length > (1024 * 1024)) {
//                throw new Exception("Image size exceeds maximum limit" + image.getBytes());
//            }

            ImageEntity imageEntity = new ImageEntity( imageName, image.getContentType(), image.getBytes());
            return imageRepository.save(imageEntity);
        } catch (MaxUploadSizeExceededException e) {
            String errorMessage = "Maximum upload size exceeded: " + e.getMaxUploadSize() + " bytes";
            throw new MaxUploadSizeExceededException(image.getSize());
        }
        catch (Exception e) {
            throw new Exception("Could not save File: " + imageName);
        }
    }


    @Override
    public void saveImages(MultipartFile[] files) throws Exception {
        FolderEntity folder =new FolderEntity();
        Arrays.asList(files).forEach(image->{
            try{
                uploadImages(image, folder);
            }
            catch (Exception e){
                throw new RuntimeException(e);

            }
        });

    }

    @Override
    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }
}
