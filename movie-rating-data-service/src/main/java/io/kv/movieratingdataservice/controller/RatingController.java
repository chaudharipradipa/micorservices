package io.kv.movieratingdataservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kv.movieratingdataservice.model.MovieRating;
import io.kv.movieratingdataservice.model.Rate;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@GetMapping("/{userId}")
	public Rate getRating(@PathVariable("userId") String userId) {
		List<MovieRating> movies = new ArrayList<>();
		MovieRating movie1 = new MovieRating("FF", 5);
		movies.add(movie1);
		MovieRating movie2 = new MovieRating("FF1", 4);
		movies.add(movie2);
		return new Rate(userId, movies);
	}

}
