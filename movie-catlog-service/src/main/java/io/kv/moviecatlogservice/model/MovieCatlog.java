package io.kv.moviecatlogservice.model;

import java.util.List;

public class MovieCatlog {

	private String userId;
	private List<Movie> movies;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
