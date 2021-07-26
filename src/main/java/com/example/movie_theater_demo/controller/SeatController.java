package com.example.movie_theater_demo.controller;

import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Seat;
import com.example.movie_theater_demo.service.AuditoriumService;
import com.example.movie_theater_demo.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seat")
public class SeatController {

    private final SeatService seatService;
    private final AuditoriumService auditoriumService;

    public SeatController(SeatService seatService, AuditoriumService auditoriumService) {
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
        for (int row = 1; row <= 10; row++) {
            Auditorium auditorium = auditoriumService.findAll().get(row -1);
            for (int seat = 1; seat <= 10; seat++) {
                Seat seatCreated = new Seat(row, seat, auditorium);
                seatService.saveOrUpdate(seatCreated);
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
        seatService.deleteAllSeats();
        return "ALL SEATS ARE DELETED";
    }

}
