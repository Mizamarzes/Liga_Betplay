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

    public void UpdatePlayer(Player player) throws SQLException {
        playerDaoInterface.updatePlayer(player);
    }

    public void DeletePlayer(int id) throws SQLException {
        playerDaoInterface.deletePlayer(id);
    }

    

}


