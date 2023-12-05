package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.UserRatingDto;
import com.movieapp.cinegraphqlapi.model.UserRating;

public class UserRatingMapper {
    private UserRatingMapper() {
    }

    public static UserRatingDto entityToDto(UserRating userRating) {
        UserRatingDto dto = new UserRatingDto();
        dto.setId(userRating.getId());
        dto.setUser(UserMapper.entityToDto(userRating.getUser()));
        dto.setMovie(MovieMapper.entityToDto(userRating.getMovie()));
        dto.setRating(userRating.getRating());
        dto.setReview(userRating.getReview());
        return dto;
    }
}
