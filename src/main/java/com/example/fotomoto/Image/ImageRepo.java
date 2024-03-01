package com.example.fotomoto.Image;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo {
    List<ImageModel> saveAll(List<ImageModel> images);
}
