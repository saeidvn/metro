package com.soldv.metro.vehicle;

import java.util.List;
import java.util.Objects;

public class Metro extends Vehicle {

    private List<String> wagons;

    public List<String> getWagons() {
        return wagons;
    }

    public void setWagons(List<String> wagons) {
        this.wagons = wagons;
    }

    @Override
    public String toString() {
        return "Metro{" +
                "wagonList=" + wagons +
                '}';
    }

    @Override
    public int object(int o1, int o2, int o3) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Metro metro = (Metro) o;
        return Objects.equals(wagons, metro.wagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wagons);
    }

}
