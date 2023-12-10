package com.movie.reviewer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.reviewer.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findAll();
	
//	@Query()
	
	

}
