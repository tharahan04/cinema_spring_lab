package com.example.cinema_spring_lab.controllers;

import com.example.cinema_spring_lab.models.Movie;
import com.example.cinema_spring_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies") //localhost:8080/movies

public class MovieController {

    @Autowired
    MovieService movieService;

    // GET /movies
    @GetMapping //localhost:8080/movies
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // GET /movies/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Integer id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(movie);
        }
    }

    // POST /movies
    @PostMapping
    public ResponseEntity<Movie> createMovie(Movie movie) {
        Movie movieToBeSaved = movieService.addMovie(movie);
        return new ResponseEntity<>(movieToBeSaved, HttpStatus.CREATED);
    }
}

