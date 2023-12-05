package com.movieapp.cinegraphqlapi.service;

import com.movieapp.cinegraphqlapi.model.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IActorService {
    void addActor(Actor actor);

    void addAllActors(List<Actor> actors);

    Actor getActorById(String actorId);
}
