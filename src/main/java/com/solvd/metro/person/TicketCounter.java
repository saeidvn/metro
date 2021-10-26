package com.solvd.metro.person;

public class TicketCounter extends Person {

    public TicketCounter(int age, String hairColor, String eyeColor) {
        super(age, hairColor, eyeColor);
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "TicketCounter{" +
                "surname='" + getSurname() + '\'' +
                ", eyeColor='" + getEyeColor() + '\'' +
                ", job='" + getJob() + '\'' +
                '}';
    }
}
