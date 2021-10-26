package com.soldv.lesson7.vehicle;

import com.soldv.lesson7.person.Person;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Vehicle {

    private int size;
    private String color;
    private LocalDateTime creationDate;
    private Person driver;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    abstract int object(int o1, int o2, int o3);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return size == vehicle.size && Objects.equals(creationDate, vehicle.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, creationDate, driver);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", creationDate=" + creationDate +
                ", driver=" + driver +
                '}';
    }
}
