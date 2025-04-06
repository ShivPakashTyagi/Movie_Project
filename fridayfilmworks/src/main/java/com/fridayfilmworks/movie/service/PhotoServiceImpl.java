package com.fridayfilmworks.movie.service;


import com.fridayfilmworks.movie.model.Photo;
import com.fridayfilmworks.movie.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;


    @Override
    public String uploadPhoto(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setType(file.getContentType());
        photo.setData(file.getBytes());

        photoRepository.save(photo);


        return "Photo Save Seccessfully";
    }

    @Override
    public Optional<Photo> findPhotoById(int id) {
      Optional<Photo> photo = photoRepository.findById(id);
        return photo;
    }

    @Override
    public List<Photo> findAllPhotos() {
      return (List<Photo>) photoRepository.findAll();

    }


}
