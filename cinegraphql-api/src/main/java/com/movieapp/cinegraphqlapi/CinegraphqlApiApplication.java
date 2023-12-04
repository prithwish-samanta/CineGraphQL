package com.movieapp.cinegraphqlapi;

import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.service.impl.ActorService;
import com.movieapp.cinegraphqlapi.service.impl.GenreService;
import com.movieapp.cinegraphqlapi.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CinegraphqlApiApplication implements CommandLineRunner {
    @Autowired
    private MovieService movieService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private ActorService actorService;

    public static void main(String[] args) {
        SpringApplication.run(CinegraphqlApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //create movie instance
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setReleaseDate("2010-07-16");
        movie.setDuration(148);
        movie.setPlotSummary("A thief who enters the dreams of others to steal their secrets.");
        movie.setPosterUrl("https://example.com/posters/inception.jpg");
        movie.setTrailerUrl("https://youtube.com/watch?v=66TuSJo4dZM");

        //genres
        Genre genre1 = new Genre();
        genre1.setName("Science Fiction");
        Genre genre2 = new Genre();
        genre2.setName("Action");
        Genre genre3 = new Genre();
        genre3.setName("Adventure");

        genreService.addGenre(genre1);
        genreService.addGenre(genre2);
        genreService.addGenre(genre3);

        //actors
        Actor actor1 = new Actor();
        actor1.setName("Leonardo DiCaprio");
        actor1.setBirthDate("1974-11-11");
        actor1.setBiography("An American actor, producer, and environmental activist.");
        actor1.setProfilePictureUrl("https://example.com/actors/leo.jpg");

        Actor actor2 = new Actor();
        actor2.setName("Joseph Gordon-Levitt");
        actor2.setBirthDate("1981-02-17");
        actor2.setBiography("An American actor, filmmaker, and entrepreneur.");
        actor2.setProfilePictureUrl("https://example.com/actors/jgl.jpg");

        actorService.addActor(actor1);
        actorService.addActor(actor2);

        movie.setGenres(List.of(genre1, genre2, genre3));
        movie.setActors(List.of(actor1, actor2));

        //add movie
        movieService.addMovie(movie);
    }
}
