package com.movie.reviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.reviewer.entity.Movie;
import com.movie.reviewer.repository.MovieRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/movie")
public class Controller {
 
    @Autowired
    private MovieRepository movieRepository;
        
    @GetMapping("fetchMovie")
    public List<Movie> findAllMovies() {
    	List<Movie> movieList = movieRepository.findAll();
        return movieList;
    }
 
//    @GetMapping("/{id}")
//    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
//       // Implement
//    }
 
    @PostMapping("addMovie")
    public Movie saveMovie(@Validated @RequestBody Movie movie) {
    	Movie movieSaved = movieRepository.save(movie);
    	return movieSaved;
        // Implement
    }
    
//    @GetMapping("fetchFilteredMovies")
//    public List<Movie> findTheMovie(@RequestParam String imdbRating,@RequestParam String AvalaibleOn) {
//    	StringBuilder searchParams = "?";
//    	searchParams.append(imdbRating);
//    	
//    	List<Movie> movieList = movieRepository.findByFilter();
//    	return movieList;
//    }
}