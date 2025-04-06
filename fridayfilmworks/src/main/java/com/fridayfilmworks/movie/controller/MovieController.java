package com.fridayfilmworks.movie.controller;

import com.fridayfilmworks.movie.repository.MovieRepository;
import com.fridayfilmworks.movie.service.FridayFilmWorksServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    FridayFilmWorksServiceImpl fridayFridayWorksService;


    @Operation(summary = "Test movie app", description = "Welcome to movie Application")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testMapping() {
        return "Welcome to Movie Application";
    }

    @Operation(summary = "Update movie Name", description = "Update (Insert) movie name by particular id")
    @RequestMapping(value = "/putmoviebyid/{id}/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public String putMovieByIdMapping(@PathVariable int id, @PathVariable String name) {
        fridayFridayWorksService.putMovieById(id,name);
        return "Movie was Updated successfully ";
    }

    @Operation(summary = "Insert movie name ", description = "Insert value by id")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String postMapping(){

        return "Movie Name Inserted Successfully";
    }

    @Operation(summary = "Delete movie", description = "Delete item (movie) by id or name")
    @RequestMapping(value = "/deletemovie/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletemovieByIdMapping(@PathVariable int id) {
        fridayFridayWorksService.deletemovieById(id);
        return "movies was Deleted successfully ";

    }

}
