package com.example.movie_theater_demo.controller;

import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Seat;
import com.example.movie_theater_demo.service.AuditoriumService;
import com.example.movie_theater_demo.service.MainService;
import com.example.movie_theater_demo.service.SeatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seat")
public class SeatController {

    private final MainService seatService;
    private final MainService auditoriumService;


    public SeatController(@Qualifier("seatService") MainService seatService, @Qualifier("auditoriumService") MainService auditoriumService) {
        this.seatService = seatService;
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/getAllSeat")
    public List<Seat> findAll(){
        return seatService.findAll();
    }

    @GetMapping("/{seatId}")
    public Seat findById(@PathVariable int seatId){

        Object id = seatService.findById(seatId);

        return (Seat) id;
    }

    @PostMapping("/addSeat")
    public Seat addSeat(@RequestBody Seat seat){
        seat.setId(0);

        seatService.saveOrUpdate(seat);
        return seat;
    }


    @PostMapping("/generateMoreSeats")
    public void generateMoreSeats(){
        List<Auditorium> auditoriums = auditoriumService.findAll();
        for(var room : auditoriums){
            for (int row = 1; row <= 10; row++) {
                for (int seat = 1; seat <= 10 ; seat++) {
                    Seat seatCreated = new Seat(row, seat, room);
                    seatService.saveOrUpdate(seatCreated);
                }
            }
        }
    }

    @PutMapping("/updateSeat")
    public Seat updateSeat(@RequestBody Seat seat){
        seatService.saveOrUpdate(seat);
        return seat;
    }

    @DeleteMapping("/deleteSeat/{seatId}")
    public String deleteSeat(@PathVariable int seatId){
        seatService.deleteById(seatId);
        return "Deleted Seat id : " + seatId;
    }

    @DeleteMapping("/deleteAllSeats")
    public String deleteAllSeats(){
        seatService.deleteAll();
        return "ALL SEATS ARE DELETED";
    }

}
