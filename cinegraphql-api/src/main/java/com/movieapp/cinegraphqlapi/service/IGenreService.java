package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Genre;
import org.springframework.stereotype.Service;

@Service
public interface IGenreService {
    void addGenre(Genre genre);
}
