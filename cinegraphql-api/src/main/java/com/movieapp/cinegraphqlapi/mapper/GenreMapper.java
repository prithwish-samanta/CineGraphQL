package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.GenreDto;
import com.movieapp.cinegraphqlapi.model.Genre;

public class GenreMapper {
    private GenreMapper() {
    }

    public static GenreDto entityToDto(Genre genre) {
        if (genre == null)
            return null;
        GenreDto dto = new GenreDto();
        dto.setGenreId(genre.getGenreId());
        dto.setName(genre.getName());
        return dto;
    }
}
