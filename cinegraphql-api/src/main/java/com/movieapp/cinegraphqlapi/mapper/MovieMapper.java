package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.ActorDto;
import com.movieapp.cinegraphqlapi.dto.DirectorDto;
import com.movieapp.cinegraphqlapi.dto.GenreDto;
import com.movieapp.cinegraphqlapi.dto.MovieDto;
import com.movieapp.cinegraphqlapi.model.Movie;

import java.util.List;

public class MovieMapper {
    public static MovieDto entityToDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setMovieId(movie.getMovieId());
        dto.setTitle(movie.getTitle());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setDuration(movie.getDuration());
        dto.setPlotSummary(movie.getPlotSummary());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setTrailerUrl(movie.getTrailerUrl());
        List<GenreDto> genreDtoList = movie.getGenres().stream()
                .map(GenreMapper::entityToDto).toList();
        dto.setGenres(genreDtoList);
        List<ActorDto> actorDtoList = movie.getActors().stream()
                .map(ActorMapper::entityToDto).toList();
        dto.setActors(actorDtoList);
        List<DirectorDto> directorDtoList = movie.getDirectors().stream()
                .map(DirectorMapper::entityToDto).toList();
        dto.setDirectors(directorDtoList);
        return dto;
    }
}
