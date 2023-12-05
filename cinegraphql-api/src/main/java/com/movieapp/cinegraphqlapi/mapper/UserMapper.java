package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.UserDto;
import com.movieapp.cinegraphqlapi.dto.UserRegistrationInput;
import com.movieapp.cinegraphqlapi.model.User;

public class UserMapper {
    private UserMapper() {
    }

    public static UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public static User inputToDto(UserRegistrationInput input) {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        return user;
    }
}
