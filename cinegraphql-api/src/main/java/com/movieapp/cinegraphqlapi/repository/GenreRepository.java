package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
}
