package com.liga_betplay.data.interfaces;

import java.sql.SQLException;

import com.liga_betplay.model.Team;

public interface TeamDaoInterface {

    void addTeam(Team team) throws SQLException;
    
    // Team findById(int id) throws SQLException;
}
