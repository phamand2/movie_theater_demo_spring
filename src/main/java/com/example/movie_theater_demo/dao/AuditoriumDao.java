package com.example.movie_theater_demo.dao;

import com.example.movie_theater_demo.entity.Auditorium;

import java.util.List;

public interface AuditoriumDao {
    List<Auditorium> findAll();
    Object findById(int theId);
    void saveOrUpdate(Auditorium theAuditorium);
    void deleteById(int theId);
    void deleteAll();
}
