package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Director;
import org.springframework.stereotype.Service;

@Service
public interface IDirectorService {
    void addDirector(Director director);

    Director getDirectorById(String director_id);
}
