package com.liga_betplay.controller;

import java.sql.SQLException;

import com.liga_betplay.model.Player;
import com.liga_betplay.model.dao.PlayerDao;
import com.liga_betplay.service.PlayerService;
import com.liga_betplay.utils.ConsoleUtils;

public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void addPlayer() throws SQLException {

        System.out.println("Enter the Name: ");
        String name = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the Age:  ");
        int age = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the Nationality: ");
        String nationality = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the Position: ");
        String position = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the Shirt Number:  ");
        int shirt_number = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the ID of the team:  ");
        int team = ConsoleUtils.verifyingIntNoRange();

        Player newPlayer = new Player(name, age, nationality, position, shirt_number, team);
        playerService.CreatePlayer(newPlayer);
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
