package com.solvd.metro.vehicle;

import com.solvd.metro.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class Suv extends Car implements Refuelable, IEngine, ISportCar {

    private static final Logger LOGGER = LogManager.getLogger(Suv.class);

    private int engineVolume;
    private int cylinders;
    private int speed;
    private int gear;
    private int tireSize;

    public Suv(int size, String color, LocalDateTime creationDate, Person driver,
               int door, int compartment, int tireSize, int passengers) {
        super(size, color, creationDate, driver, door, compartment, passengers, true);
        this.tireSize = tireSize;
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
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
    public void changeBody() {
    }

    @Override
    public void upgradeSoundSystem() {
    }

    @Override
    public void changeWheels() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suv suv = (Suv) o;
        return tireSize == suv.tireSize && this.getOffRoad().equals(suv.getOffRoad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tireSize, this.getOffRoad());
    }

    @Override
    public void engineVolume(int newValue) {
        engineVolume = newValue;
    }

    @Override
    public void cylinders(int newValue) {
        cylinders = newValue;
    }

    @Override
    public void changeGear(int newValue) {
        gear = newValue;
    }

    @Override
    public void speedUp(int increment) {
        speed = speed + increment;
    }

    @Override
    public String toString() {
        return "Suv{" +
                "engineVolume=" + engineVolume +
                ", cylinders=" + cylinders +
                ", speed=" + speed +
                ", gear=" + gear +
                ", tireSize=" + tireSize +
                ", offRoad=" + this.getOffRoad() +
                '}';
    }
}
