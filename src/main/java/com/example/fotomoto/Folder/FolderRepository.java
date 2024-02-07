package com.example.fotomoto.Folder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
    boolean existsByFolderName(String folderName);
    Optional<FolderEntity> findByFolderName(String folderName);
}
