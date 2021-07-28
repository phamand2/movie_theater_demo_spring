package com.example.movie_theater_demo.service;

import java.util.List;

public interface MainService<T> {
    List<T> findAll();
    Object findById(int theId);
    void saveOrUpdate(T theObject);
    void deleteById(int theId);
    void deleteAll();
}
