package com.liga_betplay.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.liga_betplay.model.Player;
import com.liga_betplay.model.Team;
import com.liga_betplay.utils.ConsoleUtils;

public class teamAndPlayerManagement {
    int op;
    Scanner menusc = new Scanner(System.in);

    public void show() {
        ConsoleUtils.clear();

        do {
            System.out.println("----------------------------------");
            System.out.println("    Team and Player Management    ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("1. Team Management");
            System.out.println("2. Player Management");
            
            op = menusc.nextInt(); 
    
            switch (op) {
                case 1:
                    teamMgn();
                    break;
                case 2:
                    System.out.println("submenu-2");
                    break;
            
                default:
                    break;
            }
        } while (op != 1);
    }

    public void teamMgn() {
        ConsoleUtils.clear();


        while (true) {
            ConsoleUtils.clear();

            System.out.println("---------------------------------------\n" +
            "        Gestion de Equipos        \n" +
            "---------------------------------------\n" +
            "1. Crear Equipo\n" +
            "2. Actualizar Equipo\n" +
            "3. Buscar Equipo\n" +
            "4. Eliminar Equipo\n" +
            "5. Listar todos Equipos\n" +
            "6. Avanzado\n" +
            "7. Salir\n" +
            
            "\n" +
            "Ingrese una opción: ");
            
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
                default:
                    break;
            }
        }
    }

}
