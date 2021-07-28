package com.example.movie_theater_demo.dao;
import java.util.List;

public interface MainDao<T> {
    List<T> findAll();
    Object findById(int theId);
    void saveOrUpdate(T theObject);
    void deleteById(int theId);
    void deleteAll();
}
