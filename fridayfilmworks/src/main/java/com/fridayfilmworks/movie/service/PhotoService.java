package com.fridayfilmworks.movie.service;

import com.fridayfilmworks.movie.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface PhotoService {

    String uploadPhoto(MultipartFile file) throws IOException;
    Optional<Photo> findPhotoById(int id);
    List<Photo> findAllPhotos();
}
