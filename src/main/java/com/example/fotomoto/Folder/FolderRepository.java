package com.example.fotomoto.Folder;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
    boolean existsByFolderName(String folderName);
    Optional<FolderEntity> findByFolderName(String folderName);

    List<FolderEntity> findTop4ByOrderByLastAccessedTimeDesc();
}
