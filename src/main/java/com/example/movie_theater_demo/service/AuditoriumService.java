package com.example.movie_theater_demo.service;


import com.example.movie_theater_demo.dao.AuditoriumIMPL;
import com.example.movie_theater_demo.entity.Auditorium;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService implements MainService {

    private final AuditoriumIMPL auditoriumIMPL;

    public AuditoriumService(@Qualifier("auditoriumIMPL") AuditoriumIMPL auditoriumIMPL) {
        this.auditoriumIMPL = auditoriumIMPL;
    }


//    public AuditoriumService(AuditoriumDao auditoriumDao) {
//        this.auditoriumDao = auditoriumDao;
//    }
    @Override
    public List<Auditorium> findAll() {
        return auditoriumIMPL.findAll();
    }

    @Override
    public Object findById(int movieId) {
        return auditoriumIMPL.findById(movieId);
    }

    @Override
    public void saveOrUpdate(Object auditorium) {
        auditoriumIMPL.saveOrUpdate(auditorium);
    }

    @Override
    public void deleteById(int movieId) {
        auditoriumIMPL.deleteById(movieId);
    }
    @Override
    public void deleteAll(){auditoriumIMPL.deleteAll();}
}
