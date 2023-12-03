package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {
    List<Movie> getMovies();

    Movie getMovieById(String id);
}
