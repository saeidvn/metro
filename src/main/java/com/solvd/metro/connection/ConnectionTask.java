package com.solvd.metro.connection;

public class ConnectionTask implements Runnable {

    private ConnectionPool connectionPool;
    public ConnectionTask(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = this.connectionPool.getConnection();

            connection.create();
            connection.delete();
            connection.read();
            connection.update();

            this.connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
