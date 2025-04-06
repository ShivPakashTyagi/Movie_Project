package com.fridayfilmworks.movie.repository;

import com.fridayfilmworks.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository <Movie, Integer> {
}
