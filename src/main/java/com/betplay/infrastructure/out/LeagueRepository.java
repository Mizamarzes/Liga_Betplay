package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betplay.domain.entity.League;
import com.betplay.infrastructure.config.DatabaseConfig;

public class LeagueRepository {

        private Connection connection;

    public LeagueRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public League findLeagueById(int id) throws SQLException {
        String query = "SELECT * FROM league WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    League league = new League();
                    league.setId(rs.getInt("id"));
                    league.setName(rs.getString("name"));
                    league.setCountry(rs.getString("country"));

                    return league;
                }
            }
        }
        return null;
    }

}
