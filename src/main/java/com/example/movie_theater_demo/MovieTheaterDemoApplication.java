package com.example.movie_theater_demo;

import com.example.movie_theater_demo.dao.AuditoriumDao;
import com.example.movie_theater_demo.dao.MovieDao;
import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Movie;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTheaterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTheaterDemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(MovieDao movieDao){
//        return args -> {
//
//            generateMovies(movieDao);
//
//        };
//    }

//    private void generateMovies(MovieDao movieDao){
//        Faker faker = new Faker();
//
//        for(int i = 0; i < 10; i++){
//            String title = faker.funnyName().name();
//            String description = faker.yoda().quote();
//
//            Movie movie = new Movie(title,description);
//            movieDao.saveOrUpdate(movie);
//
//        }
//    }

//    private void generateAuditoriumName(AuditoriumDao auditoriumDao){
//        Faker faker = new Faker();
//
//        for(int i = 0; i < 10; i++){
//            String name = faker.dragonBall().character();
//
//            Auditorium auditorium = new Auditorium(name);
//            auditoriumDao.saveOrUpdate(auditorium);
//        }
//    }



}
