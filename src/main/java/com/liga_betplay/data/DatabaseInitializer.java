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
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
            
            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            props.load(input);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String dropDatabaseQuery = "DROP DATABASE IF EXISTS betplay";
            statement.executeUpdate(dropDatabaseQuery);

            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS betplay";
            statement.executeUpdate(createDatabaseQuery);

            statement.execute("USE betplay");

            createLeagueTable(statement);
            createTrainerTable(statement);
            createStadiumTable(statement); 
            createTeamTable(statement);
            createTeamAwardTable(statement);
            createTypeOfEquipmentTable(statement);
            createEquipmentTable(statement);
            createTeamEquipmentTable(statement);
            createPlayerTable(statement);
            createPlayerAwardTable(statement);
            createRefereeTable(statement); 
            createGameTable(statement);
            createCallUpTable(statement);
            createCallUpPlayerTable(statement);
            createGoalTable(statement);
            createCardTable(statement);
            createIncidentTable(statement);
            createResultTable(statement);
            createInjuryTable(statement);
            createPerformanceTable(statement);
            createActivityTable(statement);
            createTrainingTable(statement);
            createTrainingPlayerTable(statement);
            createTransferTable(statement);
            createPermissionTable(statement);
            createRoleTable(statement);
            createUserTable(statement);
            createSponsorTable(statement);
            createTeamSponsorTable(statement);
            createLeagueSponsorTable(statement);            
            createCommunicationTable(statement);
            createUserCommunicationTable(statement);
            createTicketTable(statement);
            
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

    private void createLeagueTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS League (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "country VARCHAR(100) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTrainerTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Trainer (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100)," +
                                  "age INT," +
                                  "country VARCHAR(100)," +
                                  "experience INT" +
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

    private void createTeamTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Team (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "city VARCHAR(100) NOT NULL," +
                                  "stadium INT," +
                                  "trainer INT," +
                                  "league INT," +
                                  "FOREIGN KEY (stadium) REFERENCES Stadium(id)," +
                                  "FOREIGN KEY (league) REFERENCES League(id)," +
                                  "FOREIGN KEY (trainer) REFERENCES Trainer(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTeamAwardTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TeamAward (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "description TEXT," +
                                  "team_id INT," +
                                  "award_date DATE," +
                                  "FOREIGN KEY (team_id) REFERENCES Team(id) ON DELETE CASCADE" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTypeOfEquipmentTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TypeOfEquipment (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createEquipmentTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Equipment (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "type_id INT," +
                                  "quantity INT," +
                                  "team_id INT," +
                                  "acquisition_date DATE," +
                                  "FOREIGN KEY (type_id) REFERENCES TypeOfEquipment(id)," +
                                  "FOREIGN KEY (team_id) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTeamEquipmentTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TeamEquipment (" +
                                  "team_id INT," +
                                  "equipment_id INT," +
                                  "PRIMARY KEY (team_id, equipment_id)," +
                                  "FOREIGN KEY (team_id) REFERENCES Team(id)," +
                                  "FOREIGN KEY (equipment_id) REFERENCES Equipment(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createPlayerTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Player (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "age INT," +
                                  "nationality VARCHAR(100)," +
                                  "position VARCHAR(50)," +
                                  "shirt_number INT," +
                                  "team INT," +
                                  "FOREIGN KEY (team) REFERENCES Team(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createPlayerAwardTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS PlayerAward (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100) NOT NULL," +
                                  "description TEXT," +
                                  "player_id INT," +
                                  "award_date DATE," +
                                  "FOREIGN KEY (player_id) REFERENCES Player(id) ON DELETE CASCADE" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createRefereeTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Referee (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(100)," +
                                  "country VARCHAR(100)," +
                                  "experience INT" +
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
                                  "stadium INT," +
                                  "referee INT," +
                                  "league INT," +
                                  "FOREIGN KEY (home_team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (away_team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (stadium) REFERENCES Stadium(id)," +
                                  "FOREIGN KEY (referee) REFERENCES Referee(id)," +
                                  "FOREIGN KEY (league) REFERENCES League(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createCallUpTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS CallUp (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "game_id INT," +
                                  "call_up_date DATE," +
                                  "additional_info TEXT," +
                                  "FOREIGN KEY (game_id) REFERENCES Game(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createCallUpPlayerTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS CallUpPlayer (" +
                                  "call_up_id INT," +
                                  "player_id INT," +
                                  "PRIMARY KEY(call_up_id, player_id)," +
                                  "FOREIGN KEY (call_up_id) REFERENCES CallUp(id) ON DELETE CASCADE," +
                                  "FOREIGN KEY (player_id) REFERENCES Player(id) ON DELETE CASCADE" +
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

    private void createActivityTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Activity (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "description TEXT," +
                                  "duration INT" +
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
                                  "activity INT," + 
                                  "FOREIGN KEY (team) REFERENCES Team(id)," +
                                  "FOREIGN KEY (activity) REFERENCES Activity(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createTrainingPlayerTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TrainingPlayer (" +
                                  "training_id INT," +
                                  "player_id INT," +
                                  "PRIMARY KEY (training_id, player_id)," +
                                  "FOREIGN KEY (training_id) REFERENCES Training(id)," +
                                  "FOREIGN KEY (player_id) REFERENCES Player(id)" +
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

        String query = "INSERT IGNORE INTO User (id, name, email, password, role) VALUES " +
        "(1, 'santilaguado', 'santi@gmail.com', 'santi123', 1), " +
        "(2, 'mizamarzes', 'mizamarzes@gmail.com', 'mizamarzes123', 1)";
        
        statement.executeUpdate(query);
    }

    private void createRoleTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Role (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "name VARCHAR(50) NOT NULL," +
                                  "permission INT," +
                                  "FOREIGN KEY (permission) REFERENCES Permission(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);

        // Insert of default roles
        String query = "INSERT IGNORE INTO Role (id, name, permission) VALUES " +
        "(1, 'League Admin', 1), " +
        "(2, 'Technical Team', 2), " +
        "(3, 'Referee', 3), " +
        "(4, 'Team Doctor', 4), " +
        "(5, 'Journalist', 5), " +
        "(6, 'Fan', 6)";

        statement.executeUpdate(query);
    }

    private void createPermissionTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Permission (" +
                                  "id INT AUTO_INCREMENT PRIMARY KEY," +
                                  "description TEXT" +
                                  ")";
        statement.executeUpdate(createTableQuery);

        String sql = "INSERT IGNORE INTO Permission (id, description) VALUES " +
        "(1, 'Administrator Perms'), " +
        "(2, 'TechTeam Perms'), " +
        "(3, 'Referee Perms'), " +
        "(4, 'TeamDoctor Perms'), " +
        "(5, 'Journalist Perms'), " +
        "(6, 'Fan Perms')";

        statement.executeUpdate(sql);
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

    private void createTeamSponsorTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS TeamSponsor (" +
                                  "team_id INT," +
                                  "sponsor_id INT," +
                                  "PRIMARY KEY (team_id, sponsor_id)," +
                                  "FOREIGN KEY (team_id) REFERENCES Team(id)," +
                                  "FOREIGN KEY (sponsor_id) REFERENCES Sponsor(id)" +
                                  ")";
        statement.executeUpdate(createTableQuery);
    }

    private void createLeagueSponsorTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS LeagueSponsor (" +
                                  "league_id INT," +
                                  "sponsor_id INT," +
                                  "PRIMARY KEY (league_id, sponsor_id)," +
                                  "FOREIGN KEY (league_id) REFERENCES League(id)," +
                                  "FOREIGN KEY (sponsor_id) REFERENCES Sponsor(id)" +
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

    private void createUserCommunicationTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS UserCommunication (" +
                                  "user_id INT," +
                                  "communication_id INT," +
                                  "PRIMARY KEY (user_id, communication_id)," +
                                  "FOREIGN KEY (user_id) REFERENCES User(id)," +
                                  "FOREIGN KEY (communication_id) REFERENCES Communication(id)" +
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
}
