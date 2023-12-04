package com.movieapp.cinegraphqlapi.controller;

import com.movieapp.cinegraphqlapi.dto.MovieDto;
import com.movieapp.cinegraphqlapi.mapper.MovieMapper;
import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @QueryMapping
    public List<MovieDto> movies() {
        List<Movie> movieList = movieService.getMovies();
        return movieList.stream()
                .map(MovieMapper::entityToDto).toList();
    }

    @QueryMapping
    public MovieDto movie(@Argument String id) {
        Movie fetchedMovie = movieService.getMovieById(id);
        if (fetchedMovie == null)
            return null;
        return MovieMapper.entityToDto(fetchedMovie);
    }

    @QueryMapping
    public List<MovieDto> searchMovies(@Argument String query) {
        List<Movie> fetchedMovies = movieService.getSearchedMovieDetails(query);
        return fetchedMovies.stream()
                .map(MovieMapper::entityToDto).toList();
    }
}
