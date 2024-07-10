package com.betplay.infrastructure.in;

import java.sql.SQLException;
import java.util.List;

import com.betplay.application.CreatePlayerUseCase;
import com.betplay.domain.entity.Player;
import com.betplay.utils.ConsoleUtils;

public class PlayerController {
    private final CreatePlayerUseCase createPlayerUseCase;

    public PlayerController(CreatePlayerUseCase createPlayerUseCase) {
        this.createPlayerUseCase = createPlayerUseCase;
    }

    public void addPlayer() throws SQLException {

        ConsoleUtils.clear();
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
        createPlayerUseCase.CreatePlayer(newPlayer);
    }

    public Player findPlayerById() throws SQLException {
    
        ConsoleUtils.clear();
        System.out.println("Enter the Player id:  ");
        int id = ConsoleUtils.verifyingIntNoRange();
        Player player = createPlayerUseCase.FindPlayer(id);
        ConsoleUtils.clear();
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
        System.out.println("| id |     name        | age  | nationality | position | shirt_number | team |");
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
        System.out.printf("|  %-2d| %-15s | %-4d | %-11s | %-8s | %-12d | %-4d |%n",
                           player.getId(), player.getName(), player.getAge(), 
                           player.getNationality(), player.getPosition(), 
                           player.getShirt_number(), player.getTeam());
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
        ConsoleUtils.waitWindow();
        return player;
        
    }

    public List<Player> getAllPlayers() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+-----------------+------+-------------+----------+--------------+------+";
        String header = "| id |     name        | age  | nationality | position | shirt_number | team |";
        List<Player> players = createPlayerUseCase.getAllPlayers();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Player player : players) {
            System.out.printf("|  %-2d| %-15s | %-4d | %-11s | %-8s | %-12d | %-4d |%n",
            player.getId(), player.getName(), player.getAge(), 
            player.getNationality(), player.getPosition(), 
            player.getShirt_number(), player.getTeam());          
        }
        System.out.println(border);
        return players;
    }


    public void showInfo(int id) throws SQLException {
    
        Player player = createPlayerUseCase.FindPlayer(id);
        ConsoleUtils.clear();
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
        System.out.println("| id |     name        | age  | nationality | position | shirt_number | team |");
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
        System.out.printf("|  %-2d| %-15s | %-4d | %-11s | %-8s | %-12d | %-4d |%n",
                           player.getId(), player.getName(), player.getAge(), 
                           player.getNationality(), player.getPosition(), 
                           player.getShirt_number(), player.getTeam());
        System.out.println("+----+-----------------+------+-------------+----------+--------------+------+");
    }

    public void UpdatePlayers() throws SQLException {
        getAllPlayers();
        System.out.println("\n" + "Please enter the ID of the player to edit:");
        int id = ConsoleUtils.verifyingIntNoRange();
        ConsoleUtils.clear();
        showInfo(id);

        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update Team\n" +
        "2. Update Position\n" +
        "3. Update Shirt Number\n" +
        "4. Update Name\n" +
        "5. Update Age\n" +
        "6. Update Nationality\n" +
        "7. Update ALL\n"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 7);
            
        switch (op) {
            case 1:
                ConsoleUtils.clear();     
                System.out.println("Enter the new team ID:");
                int new_team = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerTeam(id, new_team);
                break;
            case 2:
                ConsoleUtils.clear();
                System.out.println("Enter the new Position:");
                String new_pos = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerPosition(id, new_pos);
                break;
            case 3:
                ConsoleUtils.clear();
                System.out.println("Enter the new Shirt Number:");
                int new_sn = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerShirtNumber(id, new_sn);
                break;
            case 4:
                ConsoleUtils.clear();
                System.out.println("Enter the new Name:");
                String new_name = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerName(id, new_name);
                break;
            case 5:
                ConsoleUtils.clear();
                System.out.println("Enter the new Age:");
                int new_age = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerAge(id, new_age);
                break;
            case 6:
                ConsoleUtils.clear();
                System.out.println("Enter the new Nationality:");
                String new_nat = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerNationality(id, new_nat);
                break;
            case 7:
                ConsoleUtils.clear();
                System.out.println("Enter new team ID:");
                new_team = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerTeam(id, new_team);

                System.out.println("Enter new position:");
                new_pos = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerPosition(id, new_pos);

                System.out.println("Enter new shirt number:");
                new_sn = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerShirtNumber(id, new_sn);

                System.out.println("Enter new name:");
                new_name = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerName(id, new_name);

                System.out.println("Enter new age:");
                new_age = ConsoleUtils.verifyingIntNoRange();
                createPlayerUseCase.updatePlayerAge(id, new_age);

                System.out.println("Enter new nationality:");
                new_nat = ConsoleUtils.verifyEntryString();
                createPlayerUseCase.updatePlayerNationality(id, new_nat);
                return;
            default:
                break;
        }
    }

    public void deletePlayer() throws SQLException {
        getAllPlayers();
        System.out.println("\n" + "Please enter the ID of the player to delete:");
        int id = ConsoleUtils.verifyingIntNoRange();
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyingIntNoRange();

        if (conf == 2) {
            createPlayerUseCase.DeletePlayer(id);
            System.out.println("Player successfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();        
    }
    
}
