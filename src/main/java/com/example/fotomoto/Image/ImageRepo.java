package com.example.fotomoto.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel, Long> {
//    List<ImageModel> saveAll(List<ImageModel> images);

}
