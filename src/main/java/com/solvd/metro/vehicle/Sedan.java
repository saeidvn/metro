package com.solvd.metro.vehicle;

import com.solvd.metro.IEngine;
import com.solvd.metro.ISportCar;
import com.solvd.metro.Refuelable;
import com.solvd.metro.person.Person;
import com.solvd.metro.person.Police;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sedan extends Car implements Refuelable, IEngine, ISportCar {

    private static final Logger LOGGER = LogManager.getLogger(Sedan.class);

    private int engineVolume;
    private int cylinders;
    private int speed;
    private int gear;
    private Boolean trunk;
    private Type type;

    public enum Type {

        HONDA("Honda Civic"), KIA("Kia Forte"), HYUNDAI("Hyundai Accent"), NISSAN("Nissan Versa");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public Sedan(int size, String color, LocalDateTime creationDate, Person driver,
                 int door, int compartment, int passengers, Boolean trunk, Type typeOfCar) {
        super(size, color, creationDate, driver, door, compartment, passengers, false);
        this.trunk = trunk;
        this.type = typeOfCar;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getTrunk() {
        return trunk;
    }

    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
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
    public void changeBody() {
    }

    @Override
    public void upgradeSoundSystem() {
    }

    @Override
    public void changeWheels() {
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "engineVolume=" + engineVolume +
                ", cylinders=" + cylinders +
                ", speed=" + speed +
                ", gear=" + gear +
                ", trunk=" + trunk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sedan sedan = (Sedan) o;
        return engineVolume == sedan.engineVolume && cylinders == sedan.cylinders && Objects.equals(trunk, sedan.trunk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume, cylinders, speed, gear, trunk);
    }
}