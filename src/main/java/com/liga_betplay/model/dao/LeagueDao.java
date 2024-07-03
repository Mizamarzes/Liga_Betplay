package com.liga_betplay.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liga_betplay.data.DatabaseConnection;
import com.liga_betplay.model.League;

public class LeagueDao {

        private Connection connection;

    public LeagueDao() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public League findLeagueById(int id) throws SQLException {
        String query = "SELECT * FROM League WHERE id = ?";
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
