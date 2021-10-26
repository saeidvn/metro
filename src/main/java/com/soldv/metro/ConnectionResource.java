package com.soldv.metro;

public class ConnectionResource implements AutoCloseable{

    public void connect() {
        System.out.println("Connection was established");
    }

    @Override
    public void close() {
        System.out.println("Connection was closed.");
    }
}
