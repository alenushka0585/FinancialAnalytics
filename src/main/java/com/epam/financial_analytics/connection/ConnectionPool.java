package com.epam.financial_analytics.connection;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.log4j.Logger;

public final class ConnectionPool {

    private String driverName;
    private String url;
    private String user;
    private String password;
    private final int poolSize =
            Integer.parseInt(ResourceBundle.getBundle("ConnectionPool").getString("db.poolsize"));

    private final BlockingQueue<Connection> connectionQueue =
            new ArrayBlockingQueue<>(poolSize);

    private Connection connection;
    private volatile static ConnectionPool instance;

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private ConnectionPool() {
        this.driverName = ResourceBundle.getBundle("ConnectionPool").getString("db.driver");
        this.url = ResourceBundle.getBundle("ConnectionPool").getString("db.url");
        this.user = ResourceBundle.getBundle("ConnectionPool").getString("db.user");
        this.password = ResourceBundle.getBundle("ConnectionPool").getString("db.password");

        Locale.setDefault(Locale.ENGLISH);

        try {
            Class.forName(driverName);
            for ( int i = 0; i < poolSize; i++) {
                connection = DriverManager.getConnection(url, user, password);
                connectionQueue.add(connection);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ConnectionPool", e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can't find database driver class", e);
        }
    }

    public static ConnectionPool getInstance(){
        if (instance == null){
            synchronized (ConnectionPool.class){
                if (instance == null){
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection takeConnection(){
        Connection newConnection;
        if (connectionQueue.isEmpty() || connectionQueue.size() < poolSize){
            for (int i = 0; i < poolSize-connectionQueue.size(); i++){
                connectionQueue.add(connection);
            }
        }
        try {
            newConnection = connectionQueue.take();
        } catch (InterruptedException e) {
            newConnection = connectionQueue.poll();
            LOGGER.error("Error connecting to the data source.", e);
        }
        return newConnection;
    }

    public void returnConnection(Connection connection) {

        try {
            connectionQueue.put(connection);
        } catch (InterruptedException e) {
            if (connectionQueue.size() >= poolSize) {
                connectionQueue.remove();
            }
            connectionQueue.offer(connection);
            LOGGER.error("Error returning the connection", e);
        }
    }
}
