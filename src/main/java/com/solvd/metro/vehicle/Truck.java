package com.solvd.metro.vehicle;

import com.solvd.metro.MainClass;
import com.solvd.metro.Refuelable;
import com.solvd.metro.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class Truck extends Car implements Refuelable {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    private String type;
    private int height;

    public Truck(int size, String color, LocalDateTime creationDate, Person driver, String brand, String model,
                 int door, int compartment, int passengers, String type, int height) {
        super(size, color, creationDate, driver, door, compartment, passengers, false);
        this.type = type;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void openTheFuelTank() {

        LOGGER.debug("The fuel tank is opened.");
    }

    @Override
    public void refuelCar() {

        LOGGER.debug("car is refueling...");
    }

    @Override
    public void closeTheFuelTank() {

        LOGGER.debug("The fuel tank is closed.");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "type='" + type + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return height == truck.height && Objects.equals(type, truck.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, height);
    }
}
