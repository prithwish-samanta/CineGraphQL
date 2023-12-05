package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.*;
import com.movieapp.cinegraphqlapi.model.Movie;

import java.util.List;

public class MovieMapper {
    private MovieMapper() {
    }

    public static MovieDto entityToDto(Movie movie) {
        if (movie == null)
            return null;
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
        //remapping the user rating dto to not go into stackoverflow error
        List<UserRatingDto> userRatingDtoList = movie.getUserRatings().stream()
                .map(userRating -> {
                    UserRatingDto ratingDto = new UserRatingDto();
                    ratingDto.setId(userRating.getId());
                    ratingDto.setUser(UserMapper.entityToDto(userRating.getUser()));
                    ratingDto.setRating(userRating.getRating());
                    ratingDto.setReview(userRating.getReview());
                    return ratingDto;
                }).toList();
        dto.setUserRatings(userRatingDtoList);
        return dto;
    }
}
