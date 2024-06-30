package com.liga_betplay.data;

import java.util.ArrayList;
import java.util.List;

import com.liga_betplay.entity.Rol;


public class DataRols {

    public static List<Rol> rols = new ArrayList<>();

    public static void defaultRols() {
        DataPerms.defaultperms();

        rols.add(new Rol(1, "League Admin", DataPerms.LeagueAdminPerms));
        rols.add(new Rol(2, "Technical Team", DataPerms.TechnicalTeamPerms));
        rols.add(new Rol(3, "Referee", DataPerms.RefereePerms));
        rols.add(new Rol(4, "Team Doctor", DataPerms.TeamDoctorPerms));
        rols.add(new Rol(5, "Journalist", DataPerms.JournalistPerms));
        rols.add(new Rol(6, "Fan", DataPerms.FanPerms));
    }

}
