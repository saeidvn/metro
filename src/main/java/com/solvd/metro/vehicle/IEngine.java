package com.solvd.metro.vehicle;

public interface IEngine {

    void engineVolume(int newValue);

    void cylinders(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

}
