package com.movieapp.cinegraphqlapi.controller;

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
    public List<Movie> movies() {
        return movieService.getMovies();
    }

    @QueryMapping
    public Movie movie(@Argument String id) {
        return movieService.getMovieById(id);
    }
}
