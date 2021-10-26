package com.soldv.lesson7.person;

public class CarDriver extends Person {

    public CarDriver(int age, String hairColor, String eyeColor) {
        super(age, hairColor, eyeColor);
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "CarDriver{" +
                "age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", hairColor='" + getHairColor() + '\'' +
                ", eyeColor='" + getHairColor() + '\'' +
                ", height=" + getHeight() +
                ", weight=" + getWeight() +
                ", job='" + getJob() + '\'' +
                '}';
    }


}
