package com.liga_betplay.controller;

import java.sql.SQLException;

import com.liga_betplay.model.Player;
import com.liga_betplay.model.dao.PlayerDao;

public class PlayerController {

    private PlayerDao playerDao;

    public PlayerController() {
        this.playerDao = new PlayerDao();
    }

    public void addPlayer(Player player) {
        try {
            playerDao.addPlayer(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public Player findPlayerById(int id) {
    //     try {
    //         return playerDao.findById(id);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         // Aquí puedes manejar la excepción de acuerdo a tu lógica de la aplicación
    //         return null; // O lanzar una excepción específica
    //     }
    // }

    // public List<Player> getAllPlayers() {
    //     try {
    //         return playerDao.findAll();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         // Aquí puedes manejar la excepción de acuerdo a tu lógica de la aplicación
    //         return null; // O lanzar una excepción específica
    //     }
    // }

    // public void updatePlayer(Player player) {
    //     try {
    //         playerDao.updatePlayer(player);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         // Aquí puedes manejar la excepción de acuerdo a tu lógica de la aplicación
    //     }
    // }

    // public void deletePlayer(int id) {
    //     try {
    //         playerDao.deletePlayer(id);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         // Aquí puedes manejar la excepción de acuerdo a tu lógica de la aplicación
    //     }
    // }

    // // Ejemplo de cómo podrías obtener el equipo de un jugador
    // public Team findTeamByPlayerId(int playerId) {
    //     try {
    //         Player player = playerDao.findById(playerId);
    //         if (player != null) {
    //             TeamDao teamDao = new TeamDao();
    //             return teamDao.findById(player.getTeam().getId());
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         // Aquí puedes manejar la excepción de acuerdo a tu lógica de la aplicación
    //     }
    //     return null;
    // }
}
