package com.soldv.lesson7.person;

public class TicketControl extends Person{

    public TicketControl(int age, String hairColor, String eyeColor) {
        super(age, hairColor, eyeColor);
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "TicketControl{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", job='" + getJob() + '\'' +
                '}';
    }
}
