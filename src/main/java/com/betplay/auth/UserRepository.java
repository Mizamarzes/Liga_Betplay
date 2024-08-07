package com.betplay.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betplay.domain.entity.User;
import com.betplay.infrastructure.config.DatabaseConfig;

public class UserRepository {
    private Connection connection;

    public UserRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authUser(User user) throws SQLException {
        String query = "SELECT * FROM user WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getName());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    String providedPassword = user.getPassword();

                    if (storedPassword.equals(providedPassword)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getUserRole(String username) throws SQLException {
        String roleName = null;
        String query = "SELECT r.name " +
                       "FROM user u " +
                       "JOIN role r ON u.role = r.id " +
                       "WHERE u.name = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
    
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    roleName = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    
        return roleName;
    }
    
    
}