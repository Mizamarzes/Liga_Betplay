package com.liga_betplay.data.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.liga_betplay.model.Player;

public interface PlayerDaoInterface {

    void addPlayer(Player player) throws SQLException;

    Player findById(int id) throws SQLException;

    List<Player> findAll() throws SQLException;

    void updatePlayerName(int id, String name) throws SQLException;

    void updatePlayerAge(int id, int age) throws SQLException;

    void updatePlayerNationality(int id, String nationality) throws SQLException;

    void updatePlayerPosition(int id, String position) throws SQLException;

    void updatePlayerShirtNumber(int id, int shirtNumber) throws SQLException;

    void updatePlayerTeam(int id, int teamId) throws SQLException;
    
    void deletePlayer(int id) throws SQLException;
}
