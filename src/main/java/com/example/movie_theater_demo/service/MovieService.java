package com.example.movie_theater_demo.service;

import com.example.movie_theater_demo.dao.MovieIMPL;
import com.example.movie_theater_demo.entity.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements MainService {

    // Dependency injection
    private final MovieIMPL movieIMPL;

    public MovieService(@Qualifier("movieIMPL") MovieIMPL movieIMPL) {
        this.movieIMPL = movieIMPL;
    }

    // Initialize the dependency
//    @Autowired
//    public MovieService(MovieDao movieDao) {
//        this.movieDAO = movieDao;
//    }

    @Override
    public List<Movie> findAll() {
        return movieIMPL.findAll();
    }

    @Override
    public Object findById(int movieId) {
        return movieIMPL.findById(movieId);
    }

    @Override
    public void saveOrUpdate(Object theMovie) {
        movieIMPL.saveOrUpdate(theMovie);
    }

    @Override
    public void deleteById(int movieId) {
        movieIMPL.deleteById(movieId);
    }

    @Override
    public void deleteAll(){movieIMPL.deleteAll();}
}


