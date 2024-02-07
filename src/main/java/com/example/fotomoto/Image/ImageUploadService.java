package com.example.fotomoto.Image;

import com.example.fotomoto.Folder.FolderEntity;
import com.example.fotomoto.Folder.FolderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ImageUploadService {
    private final ImageRepository imageRepository;

    public ImageUploadService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageEntity uploadImage(MultipartFile file, FolderEntity folder) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageEntity image = new ImageEntity();
        image.setImageName(fileName);
        image.setImageData(file.getBytes());
        image.setFolder(folder);
        return imageRepository.save(image);
    }
}