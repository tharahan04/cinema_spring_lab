package com.example.cinema_spring_lab.services;

import com.example.cinema_spring_lab.models.Movie;
import com.example.cinema_spring_lab.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
        @Autowired
        private MovieRepository movieRepository;

        public List<Movie> getAllMovies() {
                return movieRepository.findAll();
        }

        public Optional<Movie> getMovieById(int id) {
                return movieRepository.findById(id);
        }

        public Movie addMovie(Movie movie) {
                return movieRepository.save(movie);
        }


}
