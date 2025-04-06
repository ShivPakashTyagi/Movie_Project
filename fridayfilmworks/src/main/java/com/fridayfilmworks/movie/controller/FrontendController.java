

package com.fridayfilmworks.movie.controller;
import com.fridayfilmworks.movie.model.Movie;
import com.fridayfilmworks.movie.model.Photo;
import com.fridayfilmworks.movie.repository.MovieRepository;
import com.fridayfilmworks.movie.service.FridayFilmWorksServiceImpl;
import com.fridayfilmworks.movie.service.PhotoService;
import com.fridayfilmworks.movie.service.PhotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FrontendController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    FridayFilmWorksServiceImpl fridayFilmWorksService;

    @Autowired
    PhotoServiceImpl photoService;

    @Operation(summary = "Return move list", description = "Returning all movies in secquence(order) on the display")
    @RequestMapping(value = "/returnmovielist", method = RequestMethod.GET)
    public String returnMovieListMapping( final Model model){
        List<Movie> mov = fridayFilmWorksService.returnMovieList();
        model.addAttribute("movieListAttribute", mov);

        return "movieList";

    }

    @Operation(summary = "find movie by Id" )

    @RequestMapping(value = "/findmovebyid/{id}", method = RequestMethod.GET)
    public String findMovieByIdMapping(@PathVariable int id, final Model model) {
         Optional<Movie> mov = movieRepository.findById(id);
        if (mov.isPresent()) {
            model.addAttribute("movieAttribute", mov.get());
        }
        return "movie";
    }

    @Operation(summary = "Get Photo", description = "Download Photo By ")
    @RequestMapping(value = "/downloadphotobyid/{id}", method = RequestMethod.GET)
        public ResponseEntity<byte[]> downloadPhotoByIdMapping(@PathVariable int id){
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




    @Operation(summary = "erroe Mapping", description = "This mapping is called when error occurs")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorMapping(final Model model) {

            model.addAttribute("errorAttribute", "There is some error");
            return "error";
    }

    @Operation(summary = "HTML Form", description = "Accepts movie object from frontend")
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showFormMapping(final Model model) {

        model.addAttribute("movie", new Movie() );
        return "movieform";
    }


    @Operation(summary = "Save movie from HTML ", description = "Saves movie object in repository")
    @RequestMapping(value = "/savemoviefromhtml", method = RequestMethod.POST)
    public String saveMovieFromHtmlMapping(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/returnmovielist";
    }

    @Operation(summary = "Find All Photo", description = "Display All Photos At a time ")
    @RequestMapping(value = "/findallphotos", method = RequestMethod.GET)
    public String findAllPhotosMapping(final Model model){
       List<Photo> photos = photoService.findAllPhotos();
        model.addAttribute("photoListAttribute", photos);
        return "photos";
    }

}
