package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.repository.MovieRepository;
import com.movieapp.cinegraphqlapi.service.IMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService implements IMovieService {
    private final Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovies() {
        log.info("Fetching all movies");
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(String id) {
        log.info("Fetching movie with id: {}", id);
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setMovieId(getRandomMovieId());
        movieRepository.save(movie);
    }

    private String getRandomMovieId() {
        return "mm" + UUID.randomUUID();
    }
}
