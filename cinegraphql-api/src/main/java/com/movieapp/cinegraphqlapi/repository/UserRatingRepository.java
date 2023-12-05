package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.model.User;
import com.movieapp.cinegraphqlapi.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRatingRepository extends JpaRepository<UserRating, String> {
    UserRating findByUserAndMovie(User user, Movie movie);
}
