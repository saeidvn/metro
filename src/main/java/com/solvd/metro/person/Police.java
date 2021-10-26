package com.solvd.metro.person;

import com.solvd.metro.MainClass;
import com.solvd.metro.Playable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Police extends Person implements Playable {

    private List<String> officers;

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    private int id;
    private String policeName;

    public Police(int policeId, String policeName) {
        super(0, "Black", "Brown");
        this.id = policeId;
        this.policeName = policeName;
    }

    public List<String> getOfficers() {
        return officers;
    }

    public void setOfficers(List<String> officers) {
        this.officers = officers;
    }

    public void showData() {
        LOGGER.debug("Police ID is: " + id + " and " + "Police name is: " + policeName);
        System.out.println();
    }

    public Police(int age, String name, String surname, String hairColor, String eyeColor, int height,
                  int weight) {
        super(age, hairColor, eyeColor);
    }

    @Override
    public void kick() {
        System.out.println("Shooting");
    }

    @Override
    public void headKick() {
    }

    @Override
    public void pass() {
    }

    @Override
    public int something(int n1, int n2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Police{" +
                "hairColor='" + getHairColor() + '\'' +
                '}';
    }
}
