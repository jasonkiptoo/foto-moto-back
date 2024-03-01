package com.example.fotomoto.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
@Service
public class ImageServiceImpl implements ImageService{
    @Override
    public Set<ImageModel> uploadImage(MultipartFile[] files) {
        return null;
    }
}
