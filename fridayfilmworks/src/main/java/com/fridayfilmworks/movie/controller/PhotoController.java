package com.fridayfilmworks.movie.controller;

import com.fridayfilmworks.movie.model.Photo;
import com.fridayfilmworks.movie.repository.MovieRepository;
import com.fridayfilmworks.movie.service.PhotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import java.io.IOException;
import java.util.Optional;

@RestController
public class PhotoController {


    @Autowired
    PhotoServiceImpl photoService;

    @Operation(summary = "save photo", description = "Save photo Object in repository")
    @RequestMapping(value = "/uploadphoto", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String uploadPhotoMapping(@RequestParam("file") MultipartFile file) throws IOException {
        photoService.uploadPhoto(file);

        return "Photo Uploaded Succesfully";
    }

    @RequestMapping(value = "/findphotobyid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> findPhotoByIdMapping(@PathVariable int id ){
       Optional<Photo> photoOptional = photoService.findPhotoById(id);
        if (photoOptional.isPresent()) {
            Photo photo = photoOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, photo.getType())
                    .body(photo.getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

 }
