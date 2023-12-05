package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.repository.ActorRepository;
import com.movieapp.cinegraphqlapi.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService implements IActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public void addActor(Actor actor) {
        actor.setActorId(getRandomActorId());
        actorRepository.save(actor);
    }

    @Override
    public void addAllActors(List<Actor> actors) {
        actors = actors.stream().peek(actor -> actor.setActorId(getRandomActorId())).toList();
        actorRepository.saveAll(actors);
    }

    @Override
    public Actor getActorById(String actor_id) {
        return actorRepository.findById(actor_id).orElse(null);
    }

    private String getRandomActorId() {
        return "aa" + UUID.randomUUID();
    }
}
