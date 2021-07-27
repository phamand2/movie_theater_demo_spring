package com.example.movie_theater_demo.entity;

import javax.persistence.*;

@Entity(name="Seat")
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private int id;

    @Column(name="row_number")
    private int rowNumber;

    @Column(name="seat_number")
    private int number;

    @ManyToOne()
    @JoinColumn(
            name="auditorium_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="auditorium_id_fk")
    )
    private Auditorium auditorium;

    public Seat() {
    }

    public Seat(int row, int number, Auditorium auditorium) {
        this.rowNumber = row;
        this.number = number;
        this.auditorium = auditorium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int row) {
        this.rowNumber = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + rowNumber +
                ", number=" + number +
                ", auditorium=" + auditorium +
                '}';
    }
}
