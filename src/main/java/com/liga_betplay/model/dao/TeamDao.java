package com.liga_betplay.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.liga_betplay.data.DatabaseConnection;
import com.liga_betplay.data.interfaces.TeamDaoInterface;
import com.liga_betplay.model.Player;
import com.liga_betplay.model.Stadium;
import com.liga_betplay.model.Team;

public class TeamDao implements TeamDaoInterface {

    private Connection connection;

    public TeamDao() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTeam(Team team) throws SQLException {
        String query = "INSERT INTO team (name, city, stadium, trainer, league) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, team.getName());
            ps.setString(2, team.getCity());
            ps.setInt(3, team.getStadium().getId());
            ps.setInt(4, team.getTrainer().getId());
            ps.setInt(5, team.getLeague().getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // @Override
    // public Team findById(int id) throws SQLException {
    //     String query = "SELECT * FROM Team WHERE id = ?";
    //     try (PreparedStatement ps = connection.prepareStatement(query)) {
    //         ps.setInt(1, id);
    //         try (ResultSet rs = ps.executeQuery()) {
    //             if (rs.next()) {
    //                 Team team = new Team();
    //                 team.setId(rs.getInt("id"));
    //                 team.setName(rs.getString("name"));
    //                 team.setCity(rs.getString("city"));
                    
    //                 // Obtains the ID from the stadium and search the object 
    //                 int stadiumId = rs.getInt("stadium");
    //                 StadiumDao stadiumDao = new StadiumDao();
    //                 Stadium stadium = stadiumDao.findStadiumById(stadiumId);
    //                 team.setStadium(stadium);

    //                 return team;
    //             }
    //         }
    //     }
    // }
}
