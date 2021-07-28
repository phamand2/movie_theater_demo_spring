package com.example.movie_theater_demo.service;

import com.example.movie_theater_demo.dao.SeatIMPL;
import com.example.movie_theater_demo.entity.Seat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService implements MainService {

    private final SeatIMPL seatIMPL;

    public SeatService(@Qualifier("seatIMPL") SeatIMPL seatIMPL) {
        this.seatIMPL = seatIMPL;
    }

//    public SeatService(SeatDao seatDao) {
//        this.seatDao = seatDao;
//    }


    @Override
    public List<Seat> findAll() {
        return seatIMPL.findAll();
    }

    @Override
    public Object findById(int movieId) {
        return seatIMPL.findById(movieId);
    }

    @Override
    public void saveOrUpdate(Object theSeat) {
        seatIMPL.saveOrUpdate(theSeat);
    }

    @Override
    public void deleteById(int movieId) {
        seatIMPL.deleteById(movieId);
    }

    @Override
    public void deleteAll(){seatIMPL.deleteAll();}
}
