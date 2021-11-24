package com.solvd.metro.person;

import com.solvd.metro.InvalidException;

import java.util.Objects;
import java.util.function.Function;

public abstract class Person {

    private int age;
    private String name;
    private String surname;
    private String hairColor;
    private String eyeColor;
    private int height;
    private int weight;
    private String job;

    public Person(int age, String hairColor, String eyeColor) {
        this.age = age;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidException {
        if (age < 18){
            throw new InvalidException("A lessons.person has an age less than 18");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    abstract int something(int n1, int n2);

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname, hairColor, eyeColor, height, weight, job);
    }

}
