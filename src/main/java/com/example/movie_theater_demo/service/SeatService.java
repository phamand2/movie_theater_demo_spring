package com.example.movie_theater_demo.service;

import com.example.movie_theater_demo.dao.MovieDao;
import com.example.movie_theater_demo.dao.SeatDao;
import com.example.movie_theater_demo.entity.Movie;
import com.example.movie_theater_demo.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatDao seatDao;

    public SeatService(SeatDao seatDao) {
        this.seatDao = seatDao;
    }


    public List<Seat> findAll() {
        return seatDao.findAll();
    }


    public Object findById(int movieId) {
        return seatDao.findById(movieId);
    }


    public void saveOrUpdate(Seat theSeat) {
        seatDao.saveOrUpdate(theSeat);
    }


    public void deleteById(int movieId) {
        seatDao.deleteById(movieId);
    }

    public void deleteAllSeats(){seatDao.deleteAll();}
}
