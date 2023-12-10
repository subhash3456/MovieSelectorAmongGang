package com.movie.reviewer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String imdbRating;
	private String suggestedBy;
	private String genre;
	private String avalaibleIn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getSuggestedBy() {
		return suggestedBy;
	}
	public void setSuggestedBy(String suggestedBy) {
		this.suggestedBy = suggestedBy;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAvalaibleIn() {
		return avalaibleIn;
	}
	public void setAvalaibleIn(String avalaibleIn) {
		this.avalaibleIn = avalaibleIn;
	}
	
	
	
	
	
	

}
