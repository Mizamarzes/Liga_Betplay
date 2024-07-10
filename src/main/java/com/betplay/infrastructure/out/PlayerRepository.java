package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.betplay.domain.entity.Player;
import com.betplay.domain.service.PlayerService;
import com.betplay.infrastructure.config.DatabaseConfig;

public class PlayerRepository implements PlayerService{

    private Connection connection;

    public PlayerRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO player (name, age, nationality, position, shirt_number, team) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getNationality());
            ps.setString(4, player.getPosition());
            ps.setInt(5, player.getShirt_number());
            ps.setInt(6, player.getTeam());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Player findById(int id) throws SQLException {
        String query = "SELECT id, name, age, nationality, position, shirt_number, team FROM player WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Player player = new Player(id, query, id, query, query, id, id);
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
        String query = "SELECT id, name, age, nationality, position, shirt_number, team FROM player";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Player player = new Player(0, query, 0, query, query, 0, 0);
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                player.setNationality(rs.getString("nationality"));
                player.setPosition(rs.getString("position"));
                player.setShirt_number(rs.getInt("shirt_number"));
                player.setTeam(rs.getInt("team"));
                // objeto Team injuries y performances
                players.add(player);
            }
        }
        return players;
    }

    @Override
    public void updatePlayerName(int id, String name) throws SQLException {
        String query = "UPDATE player SET name = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updatePlayerAge(int id, int age) throws SQLException {
        String query = "UPDATE player SET age = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, age);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updatePlayerNationality(int id, String nationality) throws SQLException {
        String query = "UPDATE player SET nationality = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nationality);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updatePlayerPosition(int id, String position) throws SQLException {
        String query = "UPDATE player SET position = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, position);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updatePlayerShirtNumber(int id, int shirtNumber) throws SQLException {
        String query = "UPDATE player SET shirt_number = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, shirtNumber);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void updatePlayerTeam(int id, int teamId) throws SQLException {
        String query = "UPDATE player SET team = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, teamId);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePlayer(int id) throws SQLException {
        String query = "DELETE FROM player WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
