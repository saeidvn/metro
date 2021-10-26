package com.solvd.metro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Wagon {

    private static final Logger LOGGER = LogManager.getLogger(Wagon.class);

    private String wagonName;
    private int id;
    private int seats;
    private int number;

    public Wagon(int seats, int number) {
        this.seats = seats;
        this.number = number;
    }

    public Wagon(String wagonName, int wagonId) {
        this.wagonName = wagonName;
        this.id = wagonId;
    }

    public void showData() {
        LOGGER.debug("Wagon Name is: " + wagonName + ", " + "Wagon Id is: " + id);
        System.out.println();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "seats=" + seats +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return seats == wagon.seats && number == wagon.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seats, number);
    }
}