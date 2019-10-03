package io.kv.movieratingdataservice.model;

import java.util.List;

public class Rate {

	private String userId;
	private List<MovieRating> movies;

	public Rate() {

	}

	public Rate(String userId, List<MovieRating> movies) {
		this.userId = userId;
		this.movies = movies;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<MovieRating> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieRating> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rate [userId=" + userId + ", movies=" + movies + "]";
	}

}
