package com.liga_betplay.data.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.liga_betplay.entity.Player;

public interface PlayerDaoInterface {
    void addPlayer(Player player) throws SQLException;
    Player findById(int id) throws SQLException;
    List<Player> findAll() throws SQLException;
    void updatePlayer(Player player) throws SQLException;
    void deletePlayer(int id) throws SQLException;
}
