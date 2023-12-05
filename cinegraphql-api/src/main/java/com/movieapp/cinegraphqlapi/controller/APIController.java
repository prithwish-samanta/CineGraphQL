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
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class APIController {
    private final MovieService movieService;
    private final GenreService genreService;
    private final ActorService actorService;
    private final DirectorService directorService;

    public APIController(MovieService movieService, GenreService genreService, ActorService actorService, DirectorService directorService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.actorService = actorService;
        this.directorService = directorService;
    }

    @QueryMapping
    public Page<MovieDto> movies(@Argument int page, @Argument int pageSize) {
        Page<Movie> moviePage = movieService.getMovies(page, pageSize);
        return moviePage.map(MovieMapper::entityToDto);
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
    public ActorDto actor(@Argument String actorId) {
        Actor actor = actorService.getActorById(actorId);
        return ActorMapper.entityToDto(actor);
    }

    @QueryMapping
    public DirectorDto director(@Argument String directorId) {
        Director director = directorService.getDirectorById(directorId);
        return DirectorMapper.entityToDto(director);
    }
}
