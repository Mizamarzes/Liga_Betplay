package com.betplay.application;

import java.sql.SQLException;
import java.util.List;

import com.betplay.domain.entity.Player;
import com.betplay.domain.service.PlayerService;

public class CreatePlayerUseCase {
    private final PlayerService playerService;

    public CreatePlayerUseCase(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void CreatePlayer(Player player) throws SQLException {
        playerService.addPlayer(player);
    }

    public Player FindPlayer(int id) throws SQLException {
        Player player = playerService.findById(id);
        return player;
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = playerService.findAll();
        return players;
    }

    public void updatePlayerName(int id, String name) throws SQLException {
        playerService.updatePlayerName(id, name);
    }

    public void updatePlayerAge(int id, int age) throws SQLException {
        playerService.updatePlayerAge(id, age);
    }

    public void updatePlayerNationality(int id, String nationality) throws SQLException {
        playerService.updatePlayerNationality(id, nationality);
    }

    public void updatePlayerPosition(int id, String position) throws SQLException {
        playerService.updatePlayerPosition(id, position);
    }

    public void updatePlayerShirtNumber(int id, int shirtNumber) throws SQLException {
        playerService.updatePlayerShirtNumber(id, shirtNumber);
    }

    public void updatePlayerTeam(int id, int teamId) throws SQLException {
        playerService.updatePlayerTeam(id, teamId);
    }


    public void DeletePlayer(int id) throws SQLException {
        playerService.deletePlayer(id);
    }

    

}


