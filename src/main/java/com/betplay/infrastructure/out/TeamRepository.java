package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.betplay.domain.entity.Team;
import com.betplay.domain.service.TeamService;
import com.betplay.infrastructure.config.DatabaseConfig;

public class TeamRepository implements TeamService {

    private Connection connection;

    public TeamRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
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
