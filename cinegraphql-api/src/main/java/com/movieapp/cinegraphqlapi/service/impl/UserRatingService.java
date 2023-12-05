package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.dto.UserRatingInput;
import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.model.User;
import com.movieapp.cinegraphqlapi.model.UserRating;
import com.movieapp.cinegraphqlapi.repository.UserRatingRepository;
import com.movieapp.cinegraphqlapi.service.IUserRatingService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.springframework.stereotype.Service;

@Service
public class UserRatingService implements IUserRatingService {
    private final UserRatingRepository userRatingRepository;
    private final UserService userService;
    private final MovieService movieService;

    public UserRatingService(UserRatingRepository userRatingRepository, UserService userService, MovieService movieService) {
        this.userRatingRepository = userRatingRepository;
        this.userService = userService;
        this.movieService = movieService;
    }


    @Override
    public UserRating addUserRating(UserRatingInput input) {
        UserRating userRating = new UserRating();
        userRating.setId(CommonUtils.generateRandomId("ur"));
        User user = userService.getUserById(input.getUserId());
        if (user == null)
            throw new RuntimeException("No user found with id: " + input.getUserId());
        Movie movie = movieService.getMovieById(input.getMovieId());
        if (movie == null)
            throw new RuntimeException("No movie found with id: " + input.getMovieId());
        UserRating existedUserRating = userRatingRepository.findByUserAndMovie(user, movie);
        if (existedUserRating != null) {
            userRating = existedUserRating;
        } else {
            userRating.setUser(user);
            userRating.setMovie(movie);
        }
        userRating.setRating(input.getRating());
        userRating.setReview(input.getReview());
        return userRatingRepository.save(userRating);
    }
}
