// package com.liga_betplay.model.dao;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Properties;

// import com.liga_betplay.data.interfaces.TeamDaoInterface;
// import com.liga_betplay.model.Team;

// public class TeamDao implements TeamDaoInterface {
//     private Connection connection;

//     @Override
//     public void addTeam(Team team) throws SQLException {
//         String query = "INSERT INTO team (name, city, trainer, league) VALUES (?, ?, ?, ?)";
//         try (PreparedStatement ps = connection.prepareStatement(query)) {
//             ps.setString(1, team.getName());
//             ps.setString(2, team.getCity());
//             ps.setString(3, team.);
//         }
//     }
// }
