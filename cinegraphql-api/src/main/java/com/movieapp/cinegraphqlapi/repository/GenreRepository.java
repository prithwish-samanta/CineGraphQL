package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
