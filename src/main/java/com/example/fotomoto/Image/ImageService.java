    package com.example.fotomoto.Image;

    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.IOException;
    import java.util.List;
    import java.util.Set;

    @Service
    public interface ImageService {
        boolean findById(Long folderId);

        void addImage(Long folderId, MultipartFile image) throws IOException;

    }
