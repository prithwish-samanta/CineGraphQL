package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {
    Page<Movie> getMovies(int page, int pageSize);

    Movie getMovieById(String id);

    void addMovie(Movie movie);

    void addAllMovie(List<Movie> movies);

    List<Movie> getSearchedMovieDetails(String query);
}
