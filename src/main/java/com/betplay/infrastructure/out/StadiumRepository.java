package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betplay.domain.entity.Stadium;
import com.betplay.infrastructure.config.DatabaseConfig;

public class StadiumRepository {

    private Connection connection;

    public StadiumRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stadium findStadiumById(int id) throws SQLException {
        String query = "SELECT * FROM stadium WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Stadium stadium = new Stadium();
                    stadium.setId(rs.getInt("id"));
                    stadium.setName(rs.getString("name"));
                    stadium.setLocation(rs.getString("location"));
                    stadium.setCapacity(rs.getInt("capacity"));
                    return stadium;
                }
            }
        }
        return null;
    }
}
