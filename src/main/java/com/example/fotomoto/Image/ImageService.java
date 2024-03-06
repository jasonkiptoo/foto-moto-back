    package com.example.fotomoto.Image;

    import com.example.fotomoto.Folder.FolderWithImagesDTO;
    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.IOException;
    import java.util.List;

    @Service
    public interface ImageService {
        boolean findById(Long folderId);

        void addImage(Long folderId, MultipartFile image) throws IOException;
        List<FolderWithImagesDTO> getAllImages(Long folderId);

    }
