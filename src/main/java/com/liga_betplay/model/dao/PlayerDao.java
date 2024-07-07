package com.liga_betplay.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liga_betplay.data.DatabaseConnection;
import com.liga_betplay.data.interfaces.PlayerDaoInterface;
import com.liga_betplay.model.Player;

public class PlayerDao implements PlayerDaoInterface{

    private Connection connection;

    public PlayerDao() {
        try {
            this.connection = DatabaseConnection.getConnection();
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
        String query = "SELECT * FROM player WHERE id = ?";
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
        String query = "SELECT * FROM player";
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
    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE player SET name = ?, age = ?, nationality = ?, position = ?, shirt_number = ?, team_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getNationality());
            ps.setString(4, player.getPosition());
            ps.setInt(5, player.getShirt_number());
            ps.setInt(6, player.getTeam());
            ps.setInt(7, player.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
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
