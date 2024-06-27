package com.data;

import java.util.ArrayList;
import java.util.List;

import com.entity.*;

public class DataPerms {

    public static List<Permission> LeagueAdminPerms = new ArrayList<>();
    public static List<Permission> TechnicalTeamPerms = new ArrayList<>();
    public static List<Permission> RefereePerms = new ArrayList<>();
    public static List<Permission> TeamDoctorPerms = new ArrayList<>();
    public static List<Permission> JournalistPerms = new ArrayList<>();
    public static List<Permission> FanPerms = new ArrayList<>();

    public static void defaultperms() {
        LeagueAdminPerms.add(new Permission(1, "Admin"));
        TechnicalTeamPerms.add(new Permission(2, "TechTeam"));
        RefereePerms.add(new Permission(3, "Referee"));
        TeamDoctorPerms.add(new Permission(4, "TeamDoctor"));
        JournalistPerms.add(new Permission(5, "Journalist"));
        FanPerms.add(new Permission(6, "Fan"));
    }
    
}
