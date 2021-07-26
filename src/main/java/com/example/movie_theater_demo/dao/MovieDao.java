package com.example.movie_theater_demo.dao;

import com.example.movie_theater_demo.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
    Object findById(int theId);
    void saveOrUpdate(Movie theMovie);
    void deleteById(int theId);
    void deleteAll();
}
