package com.solvd.metro;

public class ConnectionTask implements Runnable {

    private ConnectionPool connectionPool;
    public ConnectionTask(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = this.connectionPool.getConnection();

        connection.create();
        connection.delete();
        connection.read();
        connection.update();
    }
}
