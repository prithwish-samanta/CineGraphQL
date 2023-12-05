package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.User;
import com.movieapp.cinegraphqlapi.repository.UserRepository;
import com.movieapp.cinegraphqlapi.service.IUserService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        user.setUserId(CommonUtils.generateRandomId("uu"));
        return userRepository.save(user);
    }
}
