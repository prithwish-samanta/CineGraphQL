package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, String> {
}
