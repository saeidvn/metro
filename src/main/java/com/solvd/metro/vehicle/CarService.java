package com.solvd.metro.vehicle;

import java.util.Scanner;

public class CarService {

    public void refuelService(Refuelable refuelable) {
        refuelable.openTheFuelTank();
        refuelable.refuelCar();
        refuelable.closeTheFuelTank();
    }

    public void sportService(String service, ISportCar sportCar) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Choose the service: ");
        String serviceCar = reader.nextLine();

        switch (serviceCar){
            case "changeBody":
                sportCar.changeBody();
                break;
            case "upgradeSoundSystem":
                sportCar.upgradeSoundSystem();
                break;
            case "changeWheels":
                sportCar.changeWheels();
                break;
            default:
                System.out.println("Invalid service");
                break;
        }

    }

}
