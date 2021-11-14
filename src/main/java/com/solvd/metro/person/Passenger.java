package com.solvd.metro.person;

import com.solvd.metro.metro.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Passenger extends Person implements Humanity {

    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);

    private Ticket ticket;

    public Passenger(int age, String hairColor, String eyeColor, Ticket ticket) {
        super(age, hairColor, eyeColor);
        this.ticket = ticket;
    }

    @Override
    public void walk() {
        LOGGER.debug("Walking");
    }

    @Override
    public void run() {
        LOGGER.debug("Running");
    }

    @Override
    public void talk() {
        LOGGER.debug("Talking");
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                '}';
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(ticket, passenger.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
