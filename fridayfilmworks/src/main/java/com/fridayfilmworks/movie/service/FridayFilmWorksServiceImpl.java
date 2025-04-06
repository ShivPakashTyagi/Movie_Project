package com.fridayfilmworks.movie.service;

import com.fridayfilmworks.movie.model.Movie;
import com.fridayfilmworks.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FridayFilmWorksServiceImpl implements FridayFilmWorksService {

    @Autowired
        MovieRepository movieRepository;

    @Override
    public String putMovieById(int id, String name) {
        movieRepository.findById(id).map(movie -> {
            movie.setMovieName(name);
            return movieRepository.save(movie);
        });
        return "Success";
    }

    @Override
    public String deletemovieById(int id) {
        movieRepository.deleteById(id);

        return "Delete Successfully";
    }

    @Override
    public List<Movie> returnMovieList() {
      return (List<Movie>) movieRepository.findAll();

    }


}


