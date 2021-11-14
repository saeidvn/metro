package com.solvd.metro.metro;

import com.solvd.metro.person.Police;

import java.util.List;
import java.util.Objects;

public class SecurityGate {

    private Boolean safe;
    private Police police;
    private int id;
    private List<String> gates;

    public SecurityGate(int id) {
        this.id = id;
    }

    public Boolean getSafe() {
        return safe;
    }

    public void setSafe(Boolean safe) {
        this.safe = safe;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getGates() {
        return gates;
    }

    public void setGates(List<String> gates) {
        this.gates = gates;
    }

    @Override
    public String toString() {
        return "SecurityGate{" +
                "safe=" + safe +
                ", police=" + police +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityGate that = (SecurityGate) o;
        return id == that.id && Objects.equals(safe, that.safe) && Objects.equals(police, that.police);
    }

    @Override
    public int hashCode() {
        return Objects.hash(safe, police, id);
    }
}
