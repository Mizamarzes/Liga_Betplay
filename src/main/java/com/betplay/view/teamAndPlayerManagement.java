package com.betplay.view;

import java.sql.SQLException;

import com.betplay.infrastructure.in.PlayerController;
import com.betplay.infrastructure.out.PlayerRepository;
import com.betplay.utils.ConsoleUtils;

import application.CreatePlayerUseCase;

public class teamAndPlayerManagement {
    int op;
    
    public void show() throws SQLException {

        do {
            ConsoleUtils.clear();
            System.out.println("----------------------------------");
            System.out.println("    Team and Player Management    ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("1. Team Management");
            System.out.println("2. Player Management");
            System.out.println("3. Exit");
            
            op = ConsoleUtils.verifyEntryInt(1, 3); 
    
            switch (op) {
                case 1:
                    teamMgn();
                    break;
                case 2:
                    PlayerMgn();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        } while (true);
    }

    public void teamMgn() throws SQLException {
        

        while (true) {
            ConsoleUtils.clear();

            System.out.println("---------------------------------------\n" +
            "        Team Management         \n" +
            "---------------------------------------\n" +
            "1. Create Team\n" +
            "2. Update Team\n" +
            "3. Search Team\n" +
            "4. Delete Team\n" +
            "5. List all Teams\n" +
            "6. Avanzado\n" +
            "7. Exit\n" +
            
            "\n" +
            "Enter an option: ");
            
            op = ConsoleUtils.verifyEntryInt(1, 7);

            // Team equipo = new Team();

            // ArrayList<Player> jugadores = new ArrayList<>();
            // ArrayList<Coach> entrenadores = new ArrayList<>();
            // ArrayList<Doctor> masajistas = new ArrayList<>();

            switch (op) {
                case 1:
                    //crearEquipo(equipo, jugadores, entrenadores, masajistas);
                    break;
                case 2:
                    // actualizarEquipo();
                    break;
                case 3:
                    //buscarEquipo();
                    break;
                case 4:
                    //eliminarEquipo();
                    break;
                case 5:
                    //listarEquipos();
                    break;
                case 6:
                    //avanzado que seria Gestión de Equipamiento - Gestión de Premios y Reconocimientos;
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

    public void PlayerMgn() throws SQLException {
        PlayerRepository pr = new PlayerRepository();
        CreatePlayerUseCase cpuu = new CreatePlayerUseCase(pr);
        PlayerController pc = new PlayerController(cpuu);
        
        while (true) {
            ConsoleUtils.clear();

            System.out.println("---------------------------------------\n" +
            "        Player Management       \n" +
            "---------------------------------------\n" +
            "1. Create Player\n" +
            "2. Update Player\n" +
            "3. Search Player\n" +
            "4. Delete Player\n" +
            "5. List All Players\n" +
            "6. Advance, prizes\n" +
            "7. Exit\n" +
            
            "\n" +
            "Enter an option: ");
            op = ConsoleUtils.verifyEntryInt(1, 7);
            
            switch (op) {
                case 1:
                    pc.addPlayer();                    
                    break;
                case 2:
                    pc.UpdatePlayers();
                    break;
                case 3:
                    pc.findPlayerById();  
                    ConsoleUtils.waitWindow();
                    break;
                case 4:
                    pc.deletePlayer();
                    break;
                case 5:
                    pc.getAllPlayers();
                    ConsoleUtils.waitWindow();
                    break;
                case 6:
                    //avanzado que seria Gestión de Equipamiento - Gestión de Premios y Reconocimientos;
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

}
