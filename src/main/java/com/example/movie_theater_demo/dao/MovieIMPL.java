package com.example.movie_theater_demo.dao;

import com.example.movie_theater_demo.entity.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MovieIMPL implements MovieDao{

    private final EntityManager entityManager;

    @Autowired
    public MovieIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Movie> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Movie> myQuery = currentSession.createQuery("from Movie");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);



        Movie movie = currentSession.get(Movie.class, theId);

        if(movie == null){
            throw new IllegalStateException("INVALID MOVIE ID");
        }

        return movie;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Movie theMovie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theMovie);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        try{
            Movie myMovie = currentSession.get(Movie.class, theId);
            currentSession.delete(myMovie);

        } catch(Exception e){
            throw new IllegalStateException("INVALID MOVIE ID");
        }

    }

    @Override
    @Transactional
    public void deleteAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        String stringQuery = "DELETE FROM Movie";
        Query query = currentSession.createQuery(stringQuery);
        query.executeUpdate();
    }
}
