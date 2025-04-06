package com.fridayfilmworks.movie.repository;

import com.fridayfilmworks.movie.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo , Integer> {

}
