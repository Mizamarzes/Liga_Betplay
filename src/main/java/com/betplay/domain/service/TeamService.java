package com.betplay.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.betplay.domain.entity.Team;

public interface TeamService {

    void addTeam(Team team) throws SQLException;
    
    Team findByIdTeam(int id) throws SQLException;

    List<Team> findAllTeams() throws SQLException;
}
