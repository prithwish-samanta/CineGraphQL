package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.repository.MovieRepository;
import com.movieapp.cinegraphqlapi.service.IMovieService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private final Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Page<Movie> getMovies(int page, int pageSize) {
        log.info("Fetching all movies");
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return movieRepository.findAll(pageRequest);
    }

    @Override
    public Movie getMovieById(String id) {
        log.info("Fetching movie with id: {}", id);
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
        movie.setMovieId(CommonUtils.generateRandomId("mm"));
        movieRepository.save(movie);
    }

    @Override
    public void addAllMovie(List<Movie> movies) {
        movies = movies.stream().map(movie -> {
            movie.setMovieId(CommonUtils.generateRandomId("mm"));
            return movie;
        }).toList();
        movieRepository.saveAll(movies);
    }

    @Override
    public List<Movie> getSearchedMovieDetails(String query) {
        return movieRepository.findByTitleContainingIgnoreCase(query, Limit.of(5));
    }
}
