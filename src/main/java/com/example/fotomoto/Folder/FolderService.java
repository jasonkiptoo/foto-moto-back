    package com.example.fotomoto.Folder;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class FolderService {
        private final FolderRepository folderRepository;

        private static final Logger logger = LoggerFactory.getLogger(FolderService.class);

        public FolderEntity addFolder(FolderEntity folder) {
            log.info("fpolde======== {} ",folder);
            folderRepository.save(folder);
            return folder;
        }

        public List<FolderEntity> getAllFolders() {
            List<FolderEntity> folders = folderRepository.findAll();
            logger.info("Retrieved {} folders", folders.size());
            return folders;
        }
        public FolderEntity getFolderById(Long folderId) {
            return folderRepository.findById(folderId).orElse(null);
        }
    }
