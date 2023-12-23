package com.movie.reviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.reviewer.entity.Movie;
import com.movie.reviewer.exception.MovieNotFoundException;
import com.movie.reviewer.repository.MovieRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/movie/")
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
    
    @GetMapping("{id}")
    Movie getMovieById(@PathVariable Long id) {
    	return movieRepository.findById(id)
    			.orElseThrow(()-> new MovieNotFoundException(id));
    }
    
    @PutMapping("{id}")
    Movie updateMovie(@RequestBody Movie newMovie,@PathVariable Long id) {
    	return movieRepository.findById(id)
    			.map(movie -> {
    			movie.setName(newMovie.getName());
    			movie.setImdbRating(newMovie.getImdbRating());
    			movie.setGenre(newMovie.getGenre());
    			movie.setAvalaibleIn(newMovie.getAvalaibleIn());
    			movie.setSuggestedBy(newMovie.getSuggestedBy());
    			return movieRepository.save(movie);
    			}).orElseThrow(() -> new MovieNotFoundException(id));
   
    }
    
    
    @DeleteMapping("{id}")
    String deleteMovie(@PathVariable Long id) {
    	if(!movieRepository.existsById(id)) {
    		throw new MovieNotFoundException(id);
    	}
    	movieRepository.deleteById(id);
    	return "movie with id " +id+ " has been deleted successfully";
    }
    

}