package com.movieapp.cinegraphqlapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movies")
public class Movie {
    @Id
    private String movieId;
    private String title;
    private String releaseDate;
    private int duration;
    private String plotSummary;
    private String posterUrl;
    private String trailerUrl;
}
