package com.example.movie_theater_demo.service;

import com.example.movie_theater_demo.dao.MovieDao;
import com.example.movie_theater_demo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    // Dependency injection
    private final MovieDao movieDAO;

    // Initialize the dependency
    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDAO = movieDao;
    }


    public List<Movie> findAll() {
        return movieDAO.findAll();
    }


    public Object findById(int movieId) {
        return movieDAO.findById(movieId);
    }


    public void saveOrUpdate(Movie theMovie) {
        movieDAO.saveOrUpdate(theMovie);
    }


    public void deleteById(int movieId) {
        movieDAO.deleteById(movieId);
    }

    public void deleteAllMovies(){movieDAO.deleteAll();}
}


