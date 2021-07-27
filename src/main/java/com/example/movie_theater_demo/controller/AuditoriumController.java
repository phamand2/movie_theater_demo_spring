package com.example.movie_theater_demo.controller;

import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.entity.Movie;
import com.example.movie_theater_demo.service.AuditoriumService;
import com.example.movie_theater_demo.service.MovieService;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/auditorium")
public class AuditoriumController {
    private final AuditoriumService auditoriumService;

    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/getAllAuditorium")
    public List<Auditorium> findAll(){
        return auditoriumService.findAll();
    }

    @GetMapping("/{auditoriumId}")
    public Auditorium findById(@PathVariable int auditoriumId){

        Object id = auditoriumService.findById(auditoriumId);

        return (Auditorium) id;
    }

    @PostMapping("/addAuditorium")
    public Auditorium addAuditorium(@RequestBody Auditorium auditorium){
        auditorium.setId(0);

        auditoriumService.saveOrUpdate(auditorium);
        return auditorium;
    }

    @PostMapping("/generateMoreAuditoriums")
    public String generateMoreAuditoriums(){
        Faker faker = new Faker();
        Auditorium auditorium;

        for(int i = 0; i < 10; i++){
            String title = faker.funnyName().name();

            auditorium = new Auditorium(title);
            auditoriumService.saveOrUpdate(auditorium);
        }
        return "10 additional auditorium added successfully";
    }

    @PutMapping("/updateAuditorium")
    public Auditorium updateAuditorium(@RequestBody Auditorium auditorium){
        auditoriumService.saveOrUpdate(auditorium);
        return auditorium;
    }

    @DeleteMapping("/deleteAuditorium/{auditoriumId}")
    public String deleteAuditorium(@PathVariable int auditoriumId){
        auditoriumService.deleteById(auditoriumId);
        return "Deleted Auditorium id : " + auditoriumId;
    }

    @DeleteMapping("/deleteAllAuditoriums")
    public String deleteAllAuditoriums(){
        auditoriumService.deleteAllAuditorium();
        return "ALL AUDITORIUMS ARE DELETED";
    }

}
