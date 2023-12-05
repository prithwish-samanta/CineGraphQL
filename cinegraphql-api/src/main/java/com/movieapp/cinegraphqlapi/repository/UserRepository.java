package com.movieapp.cinegraphqlapi.repository;

import com.movieapp.cinegraphqlapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
