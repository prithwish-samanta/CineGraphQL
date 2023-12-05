package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.dto.UserRatingInput;
import com.movieapp.cinegraphqlapi.model.UserRating;
import org.springframework.stereotype.Service;

@Service
public interface IUserRatingService {
    UserRating addUserRating(UserRatingInput input);
}
