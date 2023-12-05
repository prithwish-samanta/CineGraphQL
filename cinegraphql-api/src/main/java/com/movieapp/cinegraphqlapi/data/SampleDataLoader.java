package com.movieapp.cinegraphqlapi.data;

import com.github.javafaker.Faker;
import com.movieapp.cinegraphqlapi.model.Actor;
import com.movieapp.cinegraphqlapi.model.Director;
import com.movieapp.cinegraphqlapi.model.Genre;
import com.movieapp.cinegraphqlapi.model.Movie;
import com.movieapp.cinegraphqlapi.service.impl.ActorService;
import com.movieapp.cinegraphqlapi.service.impl.DirectorService;
import com.movieapp.cinegraphqlapi.service.impl.GenreService;
import com.movieapp.cinegraphqlapi.service.impl.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private static final Random random = new Random();
    private final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
    private final MovieService movieService;
    private final GenreService genreService;
    private final ActorService actorService;
    private final DirectorService directorService;
    private final Faker faker;

    public SampleDataLoader(MovieService movieService, GenreService genreService, ActorService actorService, DirectorService directorService, Faker faker) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.actorService = actorService;
        this.directorService = directorService;
        this.faker = faker;
    }

    private static Set<Integer> generateUniqueRandomNumberSet(int min, int max, int count) {
        Set<Integer> uniqueRandomNumbers = new HashSet<>();

        while (uniqueRandomNumbers.size() < count) {
            int randomNumber = getRandomIndexBetween(min, max);
            uniqueRandomNumbers.add(randomNumber);
        }

        return uniqueRandomNumbers;
    }

    private static int getRandomIndexBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading sample data.....");

        //genres
        log.info("operation - inserting 10 genres in the database - START");
        List<Genre> genres = IntStream.rangeClosed(1, 10).mapToObj(i -> {
            Genre genre = new Genre();
            genre.setName(faker.music().genre());
            return genre;
        }).toList();
        genreService.addAllGenres(genres);
        log.info("operation - inserting 10 genres in the database - END");

        //actors
        log.info("operation - inserting 100 actors in the database - START");
        List<Actor> actors = IntStream.rangeClosed(1, 100).mapToObj(i -> {
            Actor actor = new Actor();
            actor.setName(faker.artist().name());
            actor.setBirthDate(faker.date().birthday().toString());
            actor.setBiography(faker.lorem().characters(50));
            actor.setProfilePictureUrl(faker.avatar().image());
            return actor;
        }).toList();
        actorService.addAllActors(actors);
        log.info("operation - inserting 100 actors in the database - END");

        //directors
        log.info("operation - inserting 100 directors in the database - START");
        List<Director> directors = IntStream.rangeClosed(1, 100).mapToObj(i -> {
            Director director = new Director();
            director.setName(faker.name().fullName());
            director.setBirthDate(faker.date().birthday().toString());
            director.setBiography(faker.lorem().characters(50));
            director.setProfilePictureUrl(faker.avatar().image());
            return director;
        }).toList();
        directorService.addAllDirectors(directors);
        log.info("operation - inserting 100 directors in the database - END");

        //movies
        log.info("operation - inserting 100 movies in database  - START");
        List<Movie> movies = IntStream.rangeClosed(1, 100).mapToObj(i -> {
            Movie movie = new Movie();
            movie.setTitle(faker.funnyName().name());
            movie.setReleaseDate(faker.date().birthday().toString());
            movie.setDuration(faker.number().numberBetween(100, 220));
            movie.setPlotSummary(faker.lorem().characters(200));
            movie.setPosterUrl(faker.internet().url());
            movie.setTrailerUrl(faker.internet().url());

            Set<Integer> indexes = generateUniqueRandomNumberSet(0, 9, 5);
            List<Genre> selectedGenres = indexes.stream()
                    .map(genres::get)
                    .toList();
            movie.setGenres(selectedGenres);

            indexes = generateUniqueRandomNumberSet(0, 9, 8);
            List<Actor> selectedActors = indexes.stream()
                    .map(actors::get)
                    .toList();
            movie.setActors(selectedActors);

            movie.setDirectors(List.of(directors.get(getRandomIndexBetween(0, 99))));
            return movie;
        }).toList();
        log.info("operation - inserting 100 movies in database - END");
        movieService.addAllMovie(movies);
    }
}
