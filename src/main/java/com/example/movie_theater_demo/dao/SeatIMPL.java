package com.example.movie_theater_demo.dao;
import com.example.movie_theater_demo.entity.Seat;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SeatIMPL implements SeatDao{


    private final EntityManager entityManager;

    @Autowired
    public SeatIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Seat> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Seat> myQuery = currentSession.createQuery("from Seat ");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Object findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Seat.class, theId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Seat theSeat) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theSeat);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Seat mySeat = currentSession.get(Seat.class, theId);
        currentSession.delete(mySeat);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String stringQuery = "DELETE FROM Seat";
        Query query = currentSession.createQuery(stringQuery);
        query.executeUpdate();
    }
}
