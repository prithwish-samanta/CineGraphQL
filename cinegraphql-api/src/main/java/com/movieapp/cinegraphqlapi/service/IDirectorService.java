package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Director;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDirectorService {
    void addDirector(Director director);

    void addAllDirectors(List<Director> directors);

    Director getDirectorById(String directorId);
}
