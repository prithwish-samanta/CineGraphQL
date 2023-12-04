package com.movieapp.cinegraphqlapi.service.impl;

import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.repository.ActorRepository;
import com.movieapp.cinegraphqlapi.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private String getRandomActorId() {
        return "aa" + UUID.randomUUID();
    }
}
