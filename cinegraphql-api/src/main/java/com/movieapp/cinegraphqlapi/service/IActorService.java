package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Actor;
import org.springframework.stereotype.Service;

@Service
public interface IActorService {
    void addActor(Actor actor);
}
