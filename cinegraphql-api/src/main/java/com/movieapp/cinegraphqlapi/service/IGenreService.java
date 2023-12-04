package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGenreService {
    void addGenre(Genre genre);
    List<Genre> getAllGenres();
}
