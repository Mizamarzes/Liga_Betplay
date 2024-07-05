package com.liga_betplay.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liga_betplay.data.DatabaseConnection;
import com.liga_betplay.model.Trainer;

public class TrainerDao {

        private Connection connection;

        public TrainerDao() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trainer findTrainerById(int id) throws SQLException {
        String query = "SELECT * FROM Trainer WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                
                if (rs.next()) {
                    Trainer trainer = new Trainer(query, id, query, id);
                    trainer.setId(rs.getInt("id"));
                    trainer.setName(rs.getString("name"));
                    trainer.setAge(rs.getInt("age"));
                    trainer.setCountry(rs.getString("country"));
                    trainer.setExperience(rs.getInt("experience"));

                    return trainer;
                }
            }
        }
        return null;
    }

}
