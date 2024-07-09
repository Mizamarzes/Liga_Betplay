package com.betplay.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betplay.domain.entity.Trainer;
import com.betplay.infrastructure.config.DatabaseConfig;

public class TrainerRepository {

        private Connection connection;

        public TrainerRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trainer findTrainerById(int id) throws SQLException {
        String query = "SELECT * FROM trainer WHERE id = ?";
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
