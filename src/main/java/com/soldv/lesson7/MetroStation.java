package com.soldv.lesson7;

import com.soldv.lesson7.person.TicketControl;
import com.soldv.lesson7.person.TicketCounter;
import com.soldv.lesson7.vehicle.Metro;

import java.util.Objects;

public class MetroStation {

    private int entrance;
    private TicketCounter ticketCounter;
    private TicketControl ticketControl;
    private com.soldv.lesson7.SecurityGate securityGate;
    private Metro metro;

    public MetroStation(int entrance, Metro metro) {
        this.entrance = entrance;
        this.metro = metro;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public TicketCounter getTicketCounter() {
        return ticketCounter;
    }

    public void setTicketCounter(TicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }

    public TicketControl getTicketControl() {
        return ticketControl;
    }

    public void setTicketControl(TicketControl ticketControl) {
        this.ticketControl = ticketControl;
    }

    public com.soldv.lesson7.SecurityGate getSecurityGate() {
        return securityGate;
    }

    public void setSecurityGate(com.soldv.lesson7.SecurityGate securityGate) {
        this.securityGate = securityGate;
    }

    public Metro getMetro() {
        return metro;
    }

    public void setMetro(Metro metro) {
        this.metro = metro;
    }

    @Override
    public String toString() {
        return "MetroStation{" +
                "entrance=" + entrance +
                ", ticketCounter=" + ticketCounter +
                ", ticketControl=" + ticketControl +
                ", securityGate=" + securityGate +
                ", metro=" + metro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetroStation that = (MetroStation) o;
        return entrance == that.entrance && Objects.equals(ticketCounter, that.ticketCounter) && Objects.equals(ticketControl, that.ticketControl) && Objects.equals(securityGate, that.securityGate) && Objects.equals(metro, that.metro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrance, ticketCounter, ticketControl, securityGate, metro);
    }
}
