package com.example.movie_theater_demo.service;


import com.example.movie_theater_demo.dao.AuditoriumDao;
import com.example.movie_theater_demo.dao.MovieDao;
import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {

    private final AuditoriumDao auditoriumDao;


    public AuditoriumService(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    public List<Auditorium> findAll() {
        return auditoriumDao.findAll();
    }


    public Object findById(int movieId) {
        return auditoriumDao.findById(movieId);
    }


    public void saveOrUpdate(Auditorium auditorium) {
        auditoriumDao.saveOrUpdate(auditorium);
    }


    public void deleteById(int movieId) {
        auditoriumDao.deleteById(movieId);
    }

    public void deleteAllAuditorium(){auditoriumDao.deleteAll();}
}
