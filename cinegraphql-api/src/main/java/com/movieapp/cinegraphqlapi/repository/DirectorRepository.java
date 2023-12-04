package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, String> {
}
