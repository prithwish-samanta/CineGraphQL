package com.movieapp.cinegraphqlapi.controller;

import com.movieapp.cinegraphqlapi.dto.ActorDto;
import com.movieapp.cinegraphqlapi.dto.DirectorDto;
import com.movieapp.cinegraphqlapi.dto.GenreDto;
import com.movieapp.cinegraphqlapi.dto.MovieDto;
import com.movieapp.cinegraphqlapi.mapper.ActorMapper;
import com.movieapp.cinegraphqlapi.mapper.DirectorMapper;
import com.movieapp.cinegraphqlapi.mapper.GenreMapper;
import com.movieapp.cinegraphqlapi.mapper.MovieMapper;
import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.model.Director;
import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.service.impl.ActorService;
import com.movieapp.cinegraphqlapi.service.impl.DirectorService;
import com.movieapp.cinegraphqlapi.service.impl.GenreService;
import com.movieapp.cinegraphqlapi.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class APIController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private DirectorService directorService;

    @QueryMapping
    public List<MovieDto> movies() {
        List<Movie> movieList = movieService.getMovies();
        return movieList.stream().map(MovieMapper::entityToDto).toList();
    }

    @QueryMapping
    public MovieDto movie(@Argument String id) {
        Movie fetchedMovie = movieService.getMovieById(id);
        return MovieMapper.entityToDto(fetchedMovie);
    }

    @QueryMapping
    public List<MovieDto> searchMovies(@Argument String query) {
        List<Movie> fetchedMovies = movieService.getSearchedMovieDetails(query);
        return fetchedMovies.stream().map(MovieMapper::entityToDto).toList();
    }

    @QueryMapping
    public List<GenreDto> genres() {
        List<Genre> genreList = genreService.getAllGenres();
        return genreList.stream().map(GenreMapper::entityToDto).toList();
    }

    @QueryMapping
    public ActorDto actor(@Argument String actor_id) {
        Actor actor = actorService.getActorById(actor_id);
        return ActorMapper.entityToDto(actor);
    }

    @QueryMapping
    public DirectorDto director(@Argument String director_id) {
        Director director = directorService.getDirectorById(director_id);
        return DirectorMapper.entityToDto(director);
    }
}
