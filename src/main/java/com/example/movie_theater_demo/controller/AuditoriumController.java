package com.example.movie_theater_demo.controller;

import com.example.movie_theater_demo.entity.Auditorium;
import com.example.movie_theater_demo.service.AuditoriumService;
import com.example.movie_theater_demo.service.MainService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/auditorium")
public class AuditoriumController {
    private final MainService mainService;

    public AuditoriumController(@Qualifier("auditoriumService") MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/getAllAuditorium")
    public List<Auditorium> findAll(){
        return mainService.findAll();
    }

    @GetMapping("/{auditoriumId}")
    public Auditorium findById(@PathVariable int auditoriumId){

        Object id = mainService.findById(auditoriumId);

        return (Auditorium) id;
    }

    @PostMapping("/addAuditorium")
    public Auditorium addAuditorium(@RequestBody Auditorium auditorium){
        auditorium.setId(0);

        mainService.saveOrUpdate(auditorium);
        return auditorium;
    }

    @PostMapping("/generateMoreAuditoriums")
    public String generateMoreAuditoriums(){
        Faker faker = new Faker();
        Auditorium auditorium;

        for(int i = 0; i < 10; i++){
            String title = faker.funnyName().name();

            auditorium = new Auditorium(title);
            mainService.saveOrUpdate(auditorium);
        }
        return "10 additional auditorium added successfully";
    }

    @PutMapping("/updateAuditorium")
    public Auditorium updateAuditorium(@RequestBody Auditorium auditorium){
        mainService.saveOrUpdate(auditorium);
        return auditorium;
    }

    @DeleteMapping("/deleteAuditorium/{auditoriumId}")
    public String deleteAuditorium(@PathVariable int auditoriumId){
        mainService.deleteById(auditoriumId);
        return "Deleted Auditorium id : " + auditoriumId;
    }

    @DeleteMapping("/deleteAllAuditoriums")
    public String deleteAllAuditoriums(){
        mainService.deleteAll();
        return "ALL AUDITORIUMS ARE DELETED";
    }

}
