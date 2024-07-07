package com.liga_betplay.service;

import java.sql.SQLException;
import java.util.List;

import com.liga_betplay.data.interfaces.PlayerDaoInterface;
import com.liga_betplay.model.Player;

public class PlayerService {
    private final PlayerDaoInterface playerDaoInterface;

    public PlayerService(PlayerDaoInterface playerDaoInterface) {
        this.playerDaoInterface = playerDaoInterface;
    }

    public void CreatePlayer(Player player) throws SQLException {
        playerDaoInterface.addPlayer(player);
    }

    public Player FindPlayer(int id) throws SQLException {
        Player player = playerDaoInterface.findById(id);
        return player;
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = playerDaoInterface.findAll();
        return players;
    }

    public void updatePlayerName(int id, String name) throws SQLException {
        playerDaoInterface.updatePlayerName(id, name);
    }

    public void updatePlayerAge(int id, int age) throws SQLException {
        playerDaoInterface.updatePlayerAge(id, age);
    }

    public void updatePlayerNationality(int id, String nationality) throws SQLException {
        playerDaoInterface.updatePlayerNationality(id, nationality);
    }

    public void updatePlayerPosition(int id, String position) throws SQLException {
        playerDaoInterface.updatePlayerPosition(id, position);
    }

    public void updatePlayerShirtNumber(int id, int shirtNumber) throws SQLException {
        playerDaoInterface.updatePlayerShirtNumber(id, shirtNumber);
    }

    public void updatePlayerTeam(int id, int teamId) throws SQLException {
        playerDaoInterface.updatePlayerTeam(id, teamId);
    }


    public void DeletePlayer(int id) throws SQLException {
        playerDaoInterface.deletePlayer(id);
    }

    

}


