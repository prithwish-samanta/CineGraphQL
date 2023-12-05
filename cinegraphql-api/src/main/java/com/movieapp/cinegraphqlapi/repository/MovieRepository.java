package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Movie;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, String> {
    Optional<Movie> findById(String id);

    void save(Movie movie);

    List<Movie> findByTitleContainingIgnoreCase(String query, Limit limit);

}
