package com.liga_betplay.view;

import java.sql.SQLException;

import com.liga_betplay.model.dao.UserDao;
import com.liga_betplay.utils.ConsoleUtils;

public class mainmenu {

    @SuppressWarnings("unused")
    private String username;
    private String userRole;

    public mainmenu(String username) throws SQLException {
        this.username = username;
        UserDao userDao = new UserDao();
        userRole = userDao.getUserRole(username);

    }


    public void showmenu() throws SQLException {
        int op;

        do {

            ConsoleUtils.clear();
            System.out.println("--------------------------------------\n" +
            "      Signed in as " + userRole +    "\n" +
            "--------------------------------------\n" +
            "            BetPlay Panel             \n" +
            "       Please select an option:       \n" +
            "--------------------------------------\n" +
            "\n" +
            "1. Team and Player Management\n" +
            "2. Game Scheduling and Results\n" +
            "3. Injury and Performance Management\n" +
            "4. Trainings and Convocations\n" +
            "5. Player Transfers\n" +
            "6. Ticket Sales and Sponsorships\n" +
            "7. Communications and Public Relations\n" +
            "8. Stats and Reports\n" +
            "9. User and Role Management\n" +
            "10. Security and Access\n" +
            "11. Sign Out\n"
            );

            op = ConsoleUtils.verifyEntryInt(1, 11);

            switch (op) {
                case 1:
                    teamAndPlayerManagement menu1 = new teamAndPlayerManagement();
                    menu1.show();
                    break;
                case 2:
                    gameSchedulingAndResults menu2 = new gameSchedulingAndResults();
                    menu2.show();
                    break;
                case 3:
                    injuryAndPerformanceManagement menu3 = new injuryAndPerformanceManagement();
                    menu3.show();
                    break;
                case 4:
                    trainingsAndConvocations menu4 = new trainingsAndConvocations();
                    menu4.show();
                    break;
                case 5:
                    playerTransfers menu5 = new playerTransfers();
                    menu5.show();
                    break;
                case 6:
                    ticketSalesAndSponsorships menu6 = new ticketSalesAndSponsorships();
                    menu6.show();
                    break;
                case 7:
                    communicationsAndPublicRelations menu7 = new communicationsAndPublicRelations();
                    menu7.show();
                    break;
                case 8:
                    statsAndReports menu8 = new statsAndReports();
                    menu8.show();
                    break;
                case 9:
                    userAndRoleManagement menu9 = new userAndRoleManagement();
                    menu9.show();
                    break;
                case 10:
                    securityAndAccess menu10 = new securityAndAccess();
                    menu10.show();
                    break;
                case 11:
                    System.out.println("Bye Bye my Nigga");
                    return;
                default:
                    break;
            }

        } while (true);

    }

}

