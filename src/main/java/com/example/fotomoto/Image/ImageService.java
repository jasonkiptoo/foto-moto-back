package com.example.fotomoto.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Service
public interface ImageService {

    List<ImageModel> uploadImage(MultipartFile[] files);

    List<ImageModel> saveAllImages(List<ImageModel> images);
}
