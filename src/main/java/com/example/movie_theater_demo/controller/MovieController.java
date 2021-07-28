package com.example.movie_theater_demo.controller;

import com.example.movie_theater_demo.entity.Movie;
import com.example.movie_theater_demo.service.MainService;
import com.example.movie_theater_demo.service.MovieService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

//    private final MovieService movieService;
    private final MainService mainService;


    public MovieController(@Qualifier("movieService") MovieService mainService) {
        this.mainService = mainService;
//        this.movieService = movieService;
    }

    @GetMapping("/getAllMovies")
    public List<Movie> findAll(){
        return mainService.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie findById(@PathVariable int movieId){

        Object id = mainService.findById(movieId);

        return (Movie) id;
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
       movie.setId(0);

        mainService.saveOrUpdate(movie);
       return movie;
    }

    @PostMapping("/generateMoreMovies")
    public String generateMoreMovies(){
        Faker faker = new Faker();
        Movie movie = null;

        for(int i = 0; i < 10; i++){
            String title = faker.funnyName().name();
            String description = faker.yoda().quote();

            movie = new Movie(title,description);
            mainService.saveOrUpdate(movie);
        }
        return "10 additional movies added successfully";
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie){
        mainService.saveOrUpdate(movie);
        return movie;
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public String deleteMovie(@PathVariable int movieId){
        mainService.deleteById(movieId);
        return "Deleted Movie id : " + movieId;
    }

    @DeleteMapping("/deleteAllMovies")
    public String deleteAllMovies(){
        mainService.deleteAll();
        return "ALL MOVIES ARE DELETED";
    }


}
