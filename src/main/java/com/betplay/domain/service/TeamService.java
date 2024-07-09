package com.betplay.domain.service;

import java.sql.SQLException;

import com.betplay.domain.entity.Team;

public interface TeamService {

    void addTeam(Team team) throws SQLException;
    
    // Team findById(int id) throws SQLException;
}
