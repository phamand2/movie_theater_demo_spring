package com.example.movie_theater_demo.dao;

import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuditoriumIMPL implements AuditoriumDao{

    private final EntityManager entityManager;

    @Autowired
    public AuditoriumIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Auditorium> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Auditorium> myQuery = currentSession.createQuery("from Auditorium ");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Movie.class, theId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Auditorium theAuditorium) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theAuditorium);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Auditorium myAuditorium = currentSession.get(Auditorium.class, theId);
        currentSession.delete(myAuditorium);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String stringQuery = "DELETE FROM Auditorium";
        Query query = currentSession.createQuery(stringQuery);
        query.executeUpdate();
    }
}
