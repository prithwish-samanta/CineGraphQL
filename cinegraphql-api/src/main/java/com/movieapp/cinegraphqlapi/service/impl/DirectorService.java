package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Director;
import com.movieapp.cinegraphqlapi.repository.DirectorRepository;
import com.movieapp.cinegraphqlapi.service.IDirectorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DirectorService implements IDirectorService {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public void addDirector(Director director) {
        director.setDirectorId(getRandomDirectorId());
        directorRepository.save(director);
    }

    @Override
    public void addAllDirectors(List<Director> directors) {
        directors = directors.stream().map(director -> {
            director.setDirectorId(getRandomDirectorId());
            return director;
        }).toList();
        directorRepository.saveAll(directors);
    }

    @Override
    public Director getDirectorById(String directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }

    private String getRandomDirectorId() {
        return "dd" + UUID.randomUUID();
    }
}
