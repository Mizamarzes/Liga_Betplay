package com.liga_betplay.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseInitializer {

    public static void main(String[] args) {
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.createTables();
    }

    public void createTables() {
        Connection connection = null;
        try {
            // Load properties from db.properties file
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
            
            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            props.load(input);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            // Establish database connection
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // Create database if it doesn't exist
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS betplay";
            statement.executeUpdate(createDatabaseQuery);

            // Use the database
            statement.execute("USE betplay");

            // Create necessary tables
            createTeamTable(statement);
            createPlayerTable(statement);
            createGameTable(statement);
            createResultTable(statement);
            createGoalTable(statement);
            createCardTable(statement);
            createIncidentTable(statement);
            createInjuryTable(statement);
            createPerformanceTable(statement);
            createTrainingTable(statement);
            createActivityTable(statement);
            createTransferTable(statement);
            createRoleTable(statement);
            createUserTable(statement);
            createPermissionTable(statement);
            createSponsorTable(statement);
            createCommunicationTable(statement);
            createTicketTable(statement);
            createStadiumTable(statement);

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createTeamTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Team (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "city VARCHAR(100) NOT NULL," +
                                  "stadium VARCHAR(100) NOT NULL," +
                                  "trainer VARCHAR(100) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createPlayerTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Player (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "age INT," +
                                  "position VARCHAR(50)," +
                                  "nationality VARCHAR(100)," +
                                  "shirt_number INT," +
                                  "team INT," +
                                  "FOREIGN KEY (team) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createGameTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Game (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "home_team INT," +
                                  "away_team INT," +
                                  "date DATE," +
                                  "time TIME," +
                                  "stadium VARCHAR(100)," +
                                  "FOREIGN KEY (home_team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (away_team) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createGoalTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Goal (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "player INT," +
                                  "team INT," +
                                  "minute INT," +
                                  "game INT," +
                                  "FOREIGN KEY (player) REFERENCES Player(id)," +
                                  "FOREIGN KEY (team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createCardTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Card (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "player INT," +
                                  "game INT," +
                                  "type VARCHAR(20)," +
                                  "minute INT," +
                                  "FOREIGN KEY (player) REFERENCES Player(id)," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createIncidentTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Incident (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "game INT," +
                                  "description TEXT," +
                                  "minute INT," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }
    private void createResultTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Result (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "game INT," +
                                  "home_team_goals INT," +
                                  "away_team_goals INT," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }
    private void createInjuryTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Injury (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "player INT," +
                                  "type VARCHAR(50)," +
                                  "severity VARCHAR(50)," +
                                  "start_date DATE," +
                                  "end_date DATE," +
                                  "FOREIGN KEY (player) REFERENCES Player(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createPerformanceTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Performance (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "player INT," +
                                  "game INT," +
                                  "minutes_played INT," +
                                  "goals INT," +
                                  "assists INT," +
                                  "yellow_cards INT," +
                                  "red_cards INT," +
                                  "FOREIGN KEY (player) REFERENCES Player(id)," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTrainingTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Training (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "team INT," +
                                  "date DATE," +
                                  "time TIME," +
                                  "location VARCHAR(255)," +
                                  "activities TEXT," +
                                  "selected_players TEXT," +
                                  "FOREIGN KEY (team) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createActivityTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Activity (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "description TEXT," +
                                  "duration INT" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTransferTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Transfer (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "player INT," +
                                  "origin_team INT," +
                                  "destination_team INT," +
                                  "amount DECIMAL(10, 2)," +
                                  "date DATE," +
                                  "FOREIGN KEY (player) REFERENCES Player(id)," +
                                  "FOREIGN KEY (origin_team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (destination_team) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createUserTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS User (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "email VARCHAR(100) UNIQUE NOT NULL," +
                                  "password VARCHAR(100) NOT NULL," +
                                  "role INT," +
                                  "FOREIGN KEY (role) REFERENCES Role(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createRoleTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Role (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(50) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);

        // Insert default roles (adjust as needed)
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (1, 'Administrator')");
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (2, 'TechTeam')");
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (3, 'Referee')");
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (4, 'TeamDoctor')");
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (5, 'Journalist')");
        statement.executeUpdate("INSERT IGNORE INTO Role (id, name) VALUES (6, 'Fan')");
    }

    private void createPermissionTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Permission (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "description TEXT" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createSponsorTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Sponsor (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "type VARCHAR(50)," +
                                  "amount DECIMAL(10, 2)," +
                                  "start_date DATE," +
                                  "end_date DATE" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createCommunicationTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Communication (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "title VARCHAR(255) NOT NULL," +
                                  "content TEXT," +
                                  "publish_date DATE" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTicketTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Ticket (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "game INT," +
                                  "buyer INT," +
                                  "purchase_date DATE," +
                                  "quantity INT," +
                                  "total_price DECIMAL(10, 2)," +
                                  "location VARCHAR(100)," +
                                  "FOREIGN KEY (game) REFERENCES Game(id)," +
                                  "FOREIGN KEY (buyer) REFERENCES User(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createStadiumTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Stadium (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "location VARCHAR(255) NOT NULL," +
                                  "capacity INT" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }
}
