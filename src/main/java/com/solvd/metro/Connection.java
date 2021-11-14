package com.solvd.metro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void create() {
        try {
            System.out.println("Connection is created.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public void read() {
        try {
            System.out.println("Connection is read.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public void update() {
        try {
            System.out.println("Connection is updated.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    public void delete() {
        try {
            System.out.println("Connection is deleted.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
        }
    }
}
