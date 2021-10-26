package com.soldv.metro;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {

    private LocalDateTime expireDate;
    private int number;

    public Ticket(LocalDateTime expireDate, int number) {
        this.expireDate = expireDate;
        this.number = number;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "expireDate=" + expireDate +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number && Objects.equals(expireDate, ticket.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expireDate, number);
    }
}
