package com.liga_betplay.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liga_betplay.data.DatabaseConnection;
import com.liga_betplay.model.Stadium;

public class StadiumDao {

    private Connection connection;

    public StadiumDao() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stadium findStadiumById(int id) throws SQLException {
        String query = "SELECT * FROM Stadium WHERE id = ?";
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
