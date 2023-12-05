package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User getUserById(String id);

    User addNewUser(User user);
}
