package com.movieapp.cinegraphqlapi.mapper;

import com.movieapp.cinegraphqlapi.dto.ActorDto;
import com.movieapp.cinegraphqlapi.model.Actor;

public class ActorMapper {
    private ActorMapper() {
    }

    public static ActorDto entityToDto(Actor actor) {
        if (actor == null)
            return null;
        ActorDto dto = new ActorDto();
        dto.setActorId(actor.getActorId());
        dto.setName(actor.getName());
        dto.setBirthDate(actor.getBirthDate());
        dto.setBiography(actor.getBiography());
        dto.setProfilePictureUrl(actor.getProfilePictureUrl());
        return dto;
    }
}
