package com.example.movie_theater_demo.dao;

import com.example.movie_theater_demo.entity.Movie;
import com.example.movie_theater_demo.entity.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> findAll();
    Object findById(int theId);
    void saveOrUpdate(Seat theSeat);
    void deleteById(int theId);
    void deleteAll();
}
