package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {
}
