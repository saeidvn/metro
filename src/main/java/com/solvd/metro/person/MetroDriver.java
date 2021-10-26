package com.solvd.metro.person;

public class MetroDriver extends Person {

    public MetroDriver(int age, String hairColor, String eyeColor) {
        super(age, hairColor, eyeColor);
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "MetroDriver{" +
                "age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", job='" + getJob() + '\'' +
                '}';
    }
}
