package com.liga_betplay.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        try {
            Properties props = new Properties();
            props.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties"));

            String url = "jdbc:mysql://localhost:3306/betplay";
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Failed to load db.properties file: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to connect to database: " + e.getMessage());
        }

        return connection;
    }
}
