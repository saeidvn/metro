package com.solvd.metro.connection;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class ConnectionPool {

    private volatile static ConnectionPool instance;

    private int poolSize;
    private CopyOnWriteArrayList<Connection> connections;

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new CopyOnWriteArrayList<Connection>();
        this.buildPool();
    }

    private void buildPool() {
        IntStream.range(0, this.poolSize)
                .boxed()
                .forEach(number -> {
                    this.connections.add(new Connection());
                });
    }

    public static ConnectionPool getInstance(int PoolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(PoolSize);
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() throws InterruptedException {
        while (this.connections.isEmpty()) {
            wait();
        }
        int connectionIndex = this.connections.size() - 1;
        Connection connection = this.connections.get(connectionIndex);
        this.connections.remove(connectionIndex);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        if (this.connections.size() < this.poolSize) {
            this.connections.add(connection);
            notify();
        }
    }

    public int freeConnectionsCount() {
        return this.connections.size();
    }
}