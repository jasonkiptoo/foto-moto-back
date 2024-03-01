package com.example.fotomoto.Image;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;

    @Override
    public List<ImageModel> uploadImage(MultipartFile[] files) {
        List<ImageModel> images = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType = file.getContentType();
                byte[] fileBytes = file.getBytes();

                ImageModel image = new ImageModel(fileName, fileType, fileBytes);
                images.add(image);
            } catch (IOException e) {
                // Handle file processing error
                e.printStackTrace();
            }
        }
        return images;
    }
    @Override
    public List<ImageModel> saveAllImages(List<ImageModel> images) {
        return imageRepo.saveAll(images);
    }

    // Other methods related to image management can be added here
}
