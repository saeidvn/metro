package com.solvd.metro.person;

import com.solvd.metro.MainClass;
import com.solvd.metro.Playable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Police extends Person implements Playable {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    private Type type;
    private List<String> officers;
    private int id;
    private String policeName;

    public enum Type {

        DETECTIVE("Detective"),
        SHERIFF("Sheriff"),
        FEDERAL("Federal Investigators");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    public Police(int policeId, String policeName, Type typesOfPolice) {
        super(0, "Black", "Brown");
        this.id = policeId;
        this.policeName = policeName;
        this.type = typesOfPolice;

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
