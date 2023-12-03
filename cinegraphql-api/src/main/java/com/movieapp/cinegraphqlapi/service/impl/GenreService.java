package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.repository.GenreRepository;
import com.movieapp.cinegraphqlapi.service.IGenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenreService implements IGenreService {
    private final Logger log = LoggerFactory.getLogger(GenreService.class);
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

    private String getRandomGenreId() {
        return "gg" + UUID.randomUUID();
    }
}
