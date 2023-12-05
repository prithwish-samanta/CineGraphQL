package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Movie;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByTitleContainingIgnoreCase(String query, Limit limit);

}
