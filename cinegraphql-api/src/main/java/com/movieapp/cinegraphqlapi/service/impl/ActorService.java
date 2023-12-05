package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.repository.ActorRepository;
import com.movieapp.cinegraphqlapi.service.IActorService;
import com.movieapp.cinegraphqlapi.util.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public void addActor(Actor actor) {
        actor.setActorId(CommonUtils.generateRandomId("aa"));
        actorRepository.save(actor);
    }

    @Override
    public void addAllActors(List<Actor> actors) {
        actors = actors.stream().map(actor -> {
            actor.setActorId(CommonUtils.generateRandomId("aa"));
            return actor;
        }).toList();
        actorRepository.saveAll(actors);
    }

    @Override
    public Actor getActorById(String actorId) {
        return actorRepository.findById(actorId).orElse(null);
    }
}
