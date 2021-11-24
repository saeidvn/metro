package com.solvd.metro;

import com.solvd.metro.connection.Connection;
import com.solvd.metro.connection.ConnectionPool;
import com.solvd.metro.connection.ConnectionTask;
import com.solvd.metro.metro.MetroStation;
import com.solvd.metro.metro.SecurityGate;
import com.solvd.metro.metro.Ticket;
import com.solvd.metro.metro.Wagon;
import com.solvd.metro.person.*;
import com.solvd.metro.vehicle.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.*;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    static final int MAX_T = 3;

    public static void main(String[] args) throws IOException {

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
        LOGGER.debug(String.format("Wagon1 has %s seats.", wagon1.getSeats()));

        List<String> wagonList = new ArrayList<>();
        wagonList.add("Wagon n1");
        wagonList.add("Wagon n2");
        wagonList.add("Wagon n3");

        wagonList.forEach((n) -> {
            LOGGER.debug(n);
        });

        Wagon[] wagons = new Wagon[6];
        wagons[0] = new Wagon("Wagon", 1);
        wagons[1] = new Wagon("Wagon", 2);
        wagons[2] = new Wagon("Wagon", 3);
        wagons[3] = new Wagon("Wagon", 4);
        wagons[4] = new Wagon("Wagon", 5);
        wagons[5] = new Wagon("Wagon", 6);

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
        Suv suv = new Suv(100, "Purple", LocalDateTime.now(), carDriver1, 5,
                2, 20, 5);

        LOGGER.debug(suv.equals(suv));
        LOGGER.debug(suv.hashCode());

        Suv mySuv = new Suv(300, "Gray", LocalDateTime.now(), carDriver1, 5,
                2, 21, 5);
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

        for (Police.Type type : Police.Type.values()) {

            LOGGER.debug(type.getType());
        }

        LOGGER.debug(passenger.getTicket().getExpireDate());
        LOGGER.debug(passenger);
        LOGGER.debug(suv);

        List<String> officers = new ArrayList<>();
        officers.add("First officer");
        officers.add("Second officer");
        officers.add("Third officer");

        Police[] policeMan = new Police[6];

        Consumer<String> printConsumer = t -> System.out.println(t);
        officers.forEach(printConsumer);

        for (int i = 0; i < policeMan.length; i++) {
            policeMan[i] = new Police(1, "David", Police.Type.DETECTIVE);

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

        AudioObject speaker = new AudioObject(AudioObject.Model.PIONEER);
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
        objectList.add("frontSpoiler");
        objectList.add("rearSpoiler");
        objectList.add("frontTire");
        objectList.add("rearTire");

        Function<String, Integer> objectListMapping = String::length;
        List<Integer> objectListLength =
                objectList.stream().map(objectListMapping).collect(Collectors.toList());
        LOGGER.debug("Length of object list = " + objectListLength);

        Map<String, AudioObject> audioObjects = new HashMap<>();
        audioObjects.put("speaker", speaker);

        LOGGER.debug(String.format("The Mappings are: %s", audioObjects));
        LOGGER.debug(String.format("Is the map empty? %s", audioObjects.isEmpty()));

        objects.entrySet().stream().forEach((entry) -> {

            LOGGER.debug(entry.getKey());
            LOGGER.debug(entry.getValue());
        });

        Police police = new Police(2, "Tom", Police.Type.FEDERAL);
        police.setType(Police.Type.DETECTIVE);

        LOGGER.debug(police.getType());

        int policeType = 3;
        String stringTypes;
        switch (policeType) {
            case 1:
                stringTypes = "Detective";
                break;
            case 2:
                stringTypes = "Sheriff";
                break;
            case 3:
                stringTypes = "Federal Investigators";
                break;
            default:
                stringTypes = "Invalid police type.";
                break;
        }

        LOGGER.debug(String.format("The type of police is %s.", stringTypes));

        Sedan sedan = new Sedan(1, "Red", LocalDateTime.now(), carDriver1, 5, 3, 5, true,
                Sedan.Type.HONDA);
        sedan.setType(Sedan.Type.HONDA);

        LOGGER.debug(sedan.getType());

        int carType = 1;
        String stringType;
        switch (carType) {
            case 1:
                stringType = "Honda Civic";
                break;
            case 2:
                stringType = "Kia Forte";
                break;
            case 3:
                stringType = "Hyundai Accent";
                break;
            case 4:
                stringType = "Nissan Versa";
                break;
            default:
                stringType = "Invalid car type.";
                break;
        }
        LOGGER.debug(String.format("The type of car is %s.", stringType));

        AudioObject audioObject = new AudioObject(AudioObject.Model.PIONEER);
        audioObject.setModel(AudioObject.Model.PIONEER);

        LOGGER.debug(audioObject.getModel());

        if (audioObject.getModel() == AudioObject.Model.JVC) {

            LOGGER.debug("Your audio model is JVC.");

        } else if (audioObject.getModel() == AudioObject.Model.PIONEER) {

            LOGGER.debug("Your audio model is Pioneer.");

        } else if (audioObject.getModel() == AudioObject.Model.SONY) {

            LOGGER.debug("Your audio model is Sony.");

        } else {

            LOGGER.debug("Your audio model is not Pioneer.");
        }

        Singleton singleton1 = Singleton.getInstance();
        singleton1.setInfo("Singleton class string.");
        Singleton singleton2 = Singleton.getInstance();
        singleton2.setInfo("another Singleton class string");
        Singleton singleton3 = Singleton.getInstance();
        singleton3.setInfo("some other Singleton class string");

        LOGGER.debug(String.format("First reference: %s", singleton1.getInfo()));
        LOGGER.debug(String.format("Second reference: %s", singleton2.getInfo()));
        LOGGER.debug(String.format("Third reference: %s", singleton3.getInfo()));


        File textFile = new File("/home/sa/Downloads/NightTrain.txt");

        String text = FileUtils.readFileToString(textFile, "UTF-8");
        text = text.toLowerCase(Locale.ROOT);
        text = text.replaceAll("[^a-z0-9]", " ");

        LOGGER.debug(StringUtils.isAlphanumericSpace(text));

        List<String> textList = new ArrayList<>(Arrays.asList(StringUtils.split(text)));
        Map<String, Integer> textMap = new HashMap<>();

        textList.stream().forEach((word) -> {
            if (textMap.containsKey(word)) {
                textMap.put(word, textMap.get(word) + 1);
            } else {
                textMap.put(word, 1);
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        IntStream.range(0, 10).boxed()
                .forEach(index -> {
                    executorService.execute(new ConnectionTask(connectionPool));
                });

        try {
            Connection newConnection = connectionPool.getConnection();

            CompletableFuture.runAsync(() -> {
                newConnection.create();
            }, executorService).thenRunAsync(() -> {
                newConnection.read();
                newConnection.update();
                newConnection.delete();

                connectionPool.releaseConnection(newConnection);
            }, executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();


        AudioObject pioneerAudioObject = new AudioObject(AudioObject.Model.PIONEER);
        Function<AudioObject, String> getAudioObjectModel = audioObject4 -> {
            return audioObject4.getModel().toString();
        };

        LOGGER.debug(getAudioObjectModel.apply(pioneerAudioObject));

        try {
            Class<BodyObject> bodyObjectClass = BodyObject.class;
            Constructor<BodyObject> bodyObjectConstructor = bodyObjectClass.getConstructor();
            BodyObject bodyObject = bodyObjectClass.newInstance();

            Field colorField = bodyObject.getClass().getDeclaredField("color");
            colorField.setAccessible(true);
            colorField.set(bodyObject, "black");

            Field manufactureField = bodyObject.getClass().getDeclaredField("manufacture");
            manufactureField.setAccessible(true);
            manufactureField.set(bodyObject, "Japan");

            LOGGER.debug(bodyObject.getColor());
            LOGGER.debug(bodyObject.getManufacture());

        } catch (NoSuchMethodException
                | SecurityException
                | InstantiationException
                | IllegalAccessException
                | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 == 0)
                .limit(10)
                .forEach(x -> LOGGER.debug(x));

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> LOGGER.debug(x));

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        LOGGER.debug(listOfAllChars);

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13);
        int myNumbers = numbers.stream()
                .peek(num -> System.out.println("Will filter " + num))
                .filter(x -> x > 5)
                .findFirst()
                .get();

        LOGGER.debug(myNumbers);
    }
}
