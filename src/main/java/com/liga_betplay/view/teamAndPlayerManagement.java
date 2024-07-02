package com.liga_betplay.view;

import com.liga_betplay.utils.ConsoleUtils;

public class teamAndPlayerManagement {
    int op;
    
    public void show() {

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

    public void teamMgn() {
        
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

    public void PlayerMgn() {
        
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

}
