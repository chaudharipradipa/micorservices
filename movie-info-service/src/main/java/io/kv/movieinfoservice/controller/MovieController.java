package io.kv.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kv.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movieinfo")
public class MovieController {

	@GetMapping("/{movieId}")
	public Movie getRating(@PathVariable("movieId") String movieId) {
		switch(movieId){
		case "FF" : return new Movie("FF", "Fast Furious","Fast Furious");
		case "FF1" : return new Movie("FF1", "Fast Furious I","Fast Furious I");
		}
		return new Movie();
		
	}

}
