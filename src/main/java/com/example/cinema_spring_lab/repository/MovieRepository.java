package com.example.cinema_spring_lab.repository;

import com.example.cinema_spring_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
