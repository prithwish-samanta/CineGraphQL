package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.repository.GenreRepository;
import com.movieapp.cinegraphqlapi.service.IGenreService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void addGenre(Genre genre) {
        genre.setGenreId(CommonUtils.generateRandomId("gg"));
        genreRepository.save(genre);
    }

    @Override
    public void addAllGenres(List<Genre> genres) {
        genres = genres.stream().map(genre -> {
            genre.setGenreId(CommonUtils.generateRandomId("gg"));
            return genre;
        }).toList();
        genreRepository.saveAll(genres);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
