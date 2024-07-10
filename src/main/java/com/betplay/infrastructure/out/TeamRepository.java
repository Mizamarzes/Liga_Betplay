package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            ps.setInt(3, team.getStadium());
            ps.setInt(4, team.getTrainer());
            ps.setInt(5, team.getLeague());
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Team findByIdTeam(int id) throws SQLException {
        String query = "SELECT id, name, city, stadium, trainer, league FROM team WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Team team = new Team(id, query, query, id, id, id);
                    team.setId(rs.getInt("id"));
                    team.setName(rs.getString("name"));
                    team.setCity(rs.getString("city"));
                    team.setStadium(rs.getInt("stadium"));
                    team.setTrainer(rs.getInt("trainer"));
                    team.setLeague(rs.getInt("league"));
                    return team;
                }
            }
        }
        return null;
    }

    @Override
    public List<Team> findAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT id, name, city, stadium, trainer, league FROM team WHERE id = ?";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Team team = new Team(0, query, query, 0, 0, 0);
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setCity(rs.getString("city"));
                team.setStadium(rs.getInt("stadium"));
                team.setTrainer(rs.getInt("trainer"));
                team.setLeague(rs.getInt("league"));
                teams.add(team); // WHY SHOULD I ADD THE TEAM?
            }
        }
        return teams;
    }


}
