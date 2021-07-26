package com.example.movie_theater_demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Auditorium")
@Table(name="auditorium")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private int id;

    @Column(name="room_name")
    private String room_name;

    @OneToMany(
            mappedBy = "auditorium",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private final List<Seat> seats = new ArrayList<>();

    public Auditorium() {
    }

    public Auditorium(String room_name) {

        this.room_name = room_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
