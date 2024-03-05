package com.example.fotomoto.Folder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface FolderService {
//    private final FolderRepository folderRepository;
//    private static final Logger logger = LoggerFactory.getLogger(FolderService.class);

  FolderEntity addFolder(FolderEntity folder);
  List<FolderEntity> getAllFolders();
  FolderEntity findById(Long folderId);
}
