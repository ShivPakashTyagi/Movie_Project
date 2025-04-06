package com.fridayfilmworks.movie.service;

import com.fridayfilmworks.movie.model.Movie;

import java.util.List;

public interface FridayFilmWorksService {
    String putMovieById(int id, String name);
    String deletemovieById(int id );

    List<Movie> returnMovieList();
}
