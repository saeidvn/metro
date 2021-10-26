package com.solvd.metro;

import com.solvd.metro.person.*;
import com.solvd.metro.vehicle.Metro;
import com.solvd.metro.vehicle.Suv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        TicketCounter ticketCounter1 = new TicketCounter(21, "Yellow", "Red");
        ticketCounter1.setSurname("Jackson");
        ticketCounter1.setJob("new job");

        TicketControl ticketControl = new TicketControl(27, "Sky", "Sky");
        Police police1 = new Police(30, "Viktor", "Viktorovic", "Black",
                "Black", 170, 65);

        List<String> gateList = new ArrayList<>();
        SecurityGate securityGate1 = new SecurityGate(1);


        MetroDriver metroDriver1 = new MetroDriver(45,
                "Black", "Brown");

        metroDriver1.setName("Andy");

        Wagon wagon1 = new Wagon(200, 6);

        List<String> wagonList = new ArrayList<>();
        wagonList.add("Wagon n1");
        wagonList.add("Wagon n2");
        wagonList.add("Wagon n3");

        Wagon[] wagons = new Wagon[6];
        wagons[0] = new Wagon("Wagon", 01);
        wagons[1] = new Wagon("Wagon", 02);
        wagons[2] = new Wagon("Wagon", 03);
        wagons[3] = new Wagon("Wagon", 04);
        wagons[4] = new Wagon("Wagon", 05);
        wagons[5] = new Wagon("Wagon", 06);

        LOGGER.debug("Wagon number 1: ");

        wagons[0].showData();

        Metro metro1 = new Metro();
        metro1.setWagons(wagonList);
        metro1.setDriver(metroDriver1);
        MetroStation minsk = new MetroStation(1, metro1);
        minsk.setTicketCounter(ticketCounter1);
        minsk.setSecurityGate(securityGate1);
        securityGate1.setPolice(police1);

        LOGGER.debug(minsk.getMetro().getWagons().get(2));
        LOGGER.debug(minsk.getMetro().getDriver().getName());
        LOGGER.debug(minsk.getTicketCounter().toString());
        LOGGER.debug(minsk.getSecurityGate().getPolice().toString());

        CarDriver carDriver1 = new CarDriver(30, "Gray", "Gray");
        Suv suv = new Suv(100, "Purple", LocalDateTime.now(), carDriver1, "BMW",
                "X6", 5, 2, 21, 5);

        LOGGER.debug(suv.equals(suv));
        LOGGER.debug(suv.hashCode());

        Suv mySuv = new Suv(300, "Gray", LocalDateTime.now(), carDriver1, "Audi",
                "Q1", 5, 2, 19, 5);
        mySuv.openTheFuelTank();
        mySuv.refuelCar();
        mySuv.closeTheFuelTank();
        mySuv.isSuv();

        suv.equals(mySuv);

        List<Suv> suvCars = new ArrayList<>();
        suvCars.add(suv);
        suvCars.add(mySuv);

        LOGGER.debug(suvCars);
        LOGGER.debug(suv.equals(mySuv));

        Person person = new Passenger(20, "Gold", "Green",
                new Ticket(LocalDateTime.of(2023, 9, 10, 0, 0,
                        0, 0), 12));
        Passenger passenger = new Passenger(44, "White", "Red", new Ticket(
                LocalDateTime.of(2023, 9, 10, 0, 0, 0,
                        0), 12));

        LOGGER.debug(passenger.getTicket().getExpireDate());
        LOGGER.debug(passenger);
        LOGGER.debug(suv);

        List<String> officers = new ArrayList<>();
        officers.add("First officer");
        officers.add("Second officer");
        officers.add("Third officer");

        Police[] policeMan = new Police[6];

        for (int i = 0; i < policeMan.length; i++) {
            policeMan[i] = new Police(i+1,"Policeman " + i);

            LOGGER.debug(policeMan);
        }

        LOGGER.debug("Policeman: ");

        policeMan[0].showData();

        minsk.getSecurityGate().getPolice();

        CarDriver human = new CarDriver(27, "Purple", "Green");

        LOGGER.debug(human);

        BodyObject frontSpoiler = new BodyObject();
        BodyObject rearSpoiler = new BodyObject();
        BodyObject frontTire = new BodyObject();
        BodyObject rearTire = new BodyObject();
        List<BodyObject> bodyObjects = new ArrayList<>();
        frontSpoiler.setManufacture("Japan");
        frontTire.setManufacture("Korea");
        rearSpoiler.setColor("Black");

        bodyObjects.add(frontSpoiler);
        bodyObjects.add(rearSpoiler);
        bodyObjects.add(frontTire);
        bodyObjects.add(rearTire);

        AudioObject speaker = new AudioObject();
        Store<BodyObject, AudioObject> store = new Store<>();
        store.setData(bodyObjects);
        store.setOtherData(speaker);

        LOGGER.debug(store);

        CarWash<Suv> carWash = new CarWash<Suv>();
        List<String> serviceList = new ArrayList<>();
        serviceList.add("Interior");
        serviceList.add("Exterior");
        serviceList.add("Full");
        carWash.setServices(suvCars);

        LOGGER.debug(serviceList);
        LOGGER.debug(carWash.getServices());

        ServiceStation<String> serviceStation = new ServiceStation<>();
        serviceStation.setType("Change oil");
        serviceStation.getType();

        LOGGER.debug(serviceStation.getType());

        Map<String, BodyObject> objects = new HashMap<>();
        objects.put("frontSpoiler", frontSpoiler);
        objects.put("rearSpoiler", rearSpoiler);
        objects.put("frontTire", frontTire);
        objects.put("rearTire", rearTire);
        objects.putIfAbsent("frontWheel", frontTire);
        objects.putIfAbsent("rearWheel", rearTire);
        boolean tireExists = objects.containsKey("frontTire");
        boolean spoilerExists = objects.containsKey("rearSpoiler");

        List<String> objectList = new ArrayList<>();

        Map<String, AudioObject> audioObjects = new HashMap<>();
        audioObjects.put("speaker", speaker);

        LOGGER.debug("The Mappings are: " + audioObjects);
        LOGGER.debug("Is the map empty? " + audioObjects.isEmpty());

        for(Map.Entry<String, BodyObject> entry : objects.entrySet()) {
            LOGGER.debug(entry.getKey());
            LOGGER.debug(entry.getValue());
        }

        LOGGER.debug("conflict test");

    }
}
