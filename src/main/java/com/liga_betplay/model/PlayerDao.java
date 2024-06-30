package com.liga_betplay.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.liga_betplay.data.interfaces.PlayerDaoInterface;

public class PlayerDao implements PlayerDaoInterface{

    private Connection connection;

    public PlayerDao() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, age, nationality, position, shirt_number, team_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getNationality());
            ps.setString(4, player.getPosition());
            ps.setInt(5, player.getShirt_number());
            ps.setInt(6, player.getTeam().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Player findById(int id) throws SQLException {
        String query = "SELECT * FROM players WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Player player = new Player();
                    player.setId(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setAge(rs.getInt("age"));
                    player.setNationality(rs.getString("nationality"));
                    player.setPosition(rs.getString("position"));
                    player.setShirt_number(rs.getInt("shirt_number"));
                    // objeto Team injuries y performances
                    return player;
                }
            }
        }
        return null;
    }

    @Override
    public List<Player> findAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Player player = new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                player.setNationality(rs.getString("nationality"));
                player.setPosition(rs.getString("position"));
                player.setShirt_number(rs.getInt("shirt_number"));
                // objeto Team injuries y performances
                players.add(player);
            }
        }
        return players;
    }

    @Override
    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE players SET name = ?, age = ?, nationality = ?, position = ?, shirt_number = ?, team_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getNationality());
            ps.setString(4, player.getPosition());
            ps.setInt(5, player.getShirt_number());
            ps.setInt(6, player.getTeam().getId());
            ps.setInt(7, player.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePlayer(int id) throws SQLException {
        String query = "DELETE FROM players WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
