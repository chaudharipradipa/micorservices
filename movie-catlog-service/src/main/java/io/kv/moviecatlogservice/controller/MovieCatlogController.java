package io.kv.moviecatlogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.kv.moviecatlogservice.model.Movie;
import io.kv.moviecatlogservice.model.MovieCatlog;
import io.kv.moviecatlogservice.model.MovieRating;
import io.kv.moviecatlogservice.model.Rate;

@RestController
@RequestMapping("/moviecatlog")
public class MovieCatlogController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public MovieCatlog getMovieCatlog(@PathVariable("userId") String userId) {
		MovieCatlog movieCatlog = new MovieCatlog();
		movieCatlog.setUserId(userId);

		Rate rate = restTemplate.getForObject("http://movie-rating-data-service/rating/" + userId, Rate.class);

		/*
		 * rate.getMovies().stream().map( movieRating -> {
		 * restTemplate.getForObject("http://localhost:8082/movieinfo/"+
		 * movieRating::getMovieId, Movie.class);
		 * 
		 * }).collect(Collectors.toList());
		 */
		List<Movie> movies = new ArrayList<Movie>();
		movieCatlog.setMovies(movies);
		for (MovieRating movierate : rate.getMovies()) {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movieinfo/" + movierate.getMovieId(),
					Movie.class);
			movie.setRating(movierate.getRate());
			movies.add(movie);
		}
		movieCatlog.setMovies(movies);

		return movieCatlog;

	}

}
