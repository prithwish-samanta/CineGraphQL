package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Director;
import com.movieapp.cinegraphqlapi.repository.DirectorRepository;
import com.movieapp.cinegraphqlapi.service.IDirectorService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService implements IDirectorService {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public void addDirector(Director director) {
        director.setDirectorId(CommonUtils.generateRandomId("dd"));
        directorRepository.save(director);
    }

    @Override
    public void addAllDirectors(List<Director> directors) {
        directors = directors.stream().map(director -> {
            director.setDirectorId(CommonUtils.generateRandomId("dd"));
            return director;
        }).toList();
        directorRepository.saveAll(directors);
    }

    @Override
    public Director getDirectorById(String directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }
}
