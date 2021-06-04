package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ParadiseSQL";
    private static final String USER = "bastier";
    private static final String PASSWORD = "bastier";

    // SINGLETON
    private static Connection connection;

    // private to avoid extern instantiate
    private ConnectionManager() {

    }

    private static void loadDriver() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException nfe) {
            nfe.printStackTrace();
            System.err.println("Driver MySQL not found");
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                loadDriver();
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException("Can't connect to database.");
            }
        }
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch(SQLException e) {
            System.err.println("Can't closing connection");
        }
    }

}
