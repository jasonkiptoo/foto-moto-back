package com.example.fotomoto.Folder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface FolderService {
//    private final FolderRepository folderRepository;
//    private static final Logger logger = LoggerFactory.getLogger(FolderService.class);

  FolderEntity addFolder(FolderEntity folder);
  List<FolderEntity> getAllFolders();

//  FolderEntity getFolderById(Long folderId);

  FolderEntity findById(Long folderId);



//        public List<FolderEntity> getAllFolders() {
//            List<FolderEntity> folders = folderRepository.findAll();
//            logger.info("Retrieved {} folders", folders.size());
//            folders.forEach(folder -> folder.setFolderImages(null));
//            return folders;
//        }
//        public FolderEntity getFolderById(Long folderId) {
//            return folderRepository.findById(folderId).orElse(null);
//        }
//
//        public void updateFolder(FolderEntity folder) {
//            folderRepository.save(folder);
//        }
//
//        public List<FolderDTO> getLastAccessedFolders() {
//            List<FolderEntity> folders = folderRepository.findTop4ByOrderByLastAccessedTimeDesc();
//            List<FolderDTO> folderDTOs = new ArrayList<>();
//            for (FolderEntity folder : folders) {
//                int imageCount = folder.getFolderImages().size();
//                ImageDTO folderImageDTO = null;
//                Set<ImageModel> folderImages = folder.getFolderImages();
//                if (!folderImages.isEmpty()) {
//                    ImageModel firstImage = folderImages.iterator().next();
//                    folderImageDTO = new ImageDTO(firstImage.getName(),firstImage.getType(),firstImage.getPicByte());
//                }
//                FolderDTO folderDTO = new FolderDTO(folder.getFolderId(), folder.getFolderName(), folder.getLastAccessedTime(), imageCount, folderImageDTO);
//                folderDTOs.add(folderDTO);
//            }
//            return folderDTOs;
//        }
//


}
