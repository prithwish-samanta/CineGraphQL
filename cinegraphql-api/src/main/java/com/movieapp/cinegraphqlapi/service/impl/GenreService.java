package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.repository.GenreRepository;
import com.movieapp.cinegraphqlapi.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void addGenre(Genre genre) {
        genre.setGenreId(getRandomGenreId());
        genreRepository.save(genre);
    }

    @Override
    public void addAllGenres(List<Genre> genres) {
        genres = genres.stream().peek(genre -> genre.setGenreId(getRandomGenreId())).toList();
        genreRepository.saveAll(genres);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    private String getRandomGenreId() {
        return "gg" + UUID.randomUUID();
    }
}
