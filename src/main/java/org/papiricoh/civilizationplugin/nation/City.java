package org.papiricoh.civilizationplugin.nation;

import org.papiricoh.civilizationplugin.nation.range.CityType;
import org.papiricoh.civilizationplugin.player.CityPlayer;
import org.papiricoh.civilizationplugin.player.roles.CityRole;

import java.util.ArrayList;
import java.util.Comparator;

public class City {
    private String name;
    private String preName;
    private CityType cityType;
    private ArrayList<CityPlayer> members;

    public City(String name) {
        this.name = name;
        this.cityType = CityType.SETTLEMENT;
        this.members = new ArrayList<>();
    }

    public City(String name, CityType cityType) {
        this(name);
        this.cityType = cityType;
    }

    public void addPlayer(CityPlayer player) {
        this.members.add(player);
    }

    public ArrayList<CityPlayer> getMembers() {
        return this.members != null ? this.members : new ArrayList<>();
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return preName != null ? String.format("%s %s", preName, name) : name;
    }

    public CityPlayer getPlayerByName(String name) {
        return findPlayerByName(name);
    }
    
    public boolean changePlayerRole(String userPlayer, String targetPlayer, int newRole) {
        CityPlayer userPlayerObject = findPlayerByName(userPlayer);
        CityRole newCityRole = CityRole.values()[newRole];
    
        if (userPlayerObject == null) {
            return false;
        }
    
        if (userPlayer.equals(targetPlayer) && members.size() > 1) {
            assignNewRoleToPlayer(userPlayerObject, newCityRole);
            assignLeaderRoleToHighestRanked();
            return true;
        }
    
        if (userPlayerObject.getRole() == CityRole.LEADER) {
            CityPlayer targetPlayerObject = findPlayerByName(targetPlayer);
            if (targetPlayerObject != null) {
                assignNewRoleToPlayer(targetPlayerObject, newCityRole);
                return true;
            }
        }
    
        return false;
    }

    private void assignNewRoleToPlayer(CityPlayer player, CityRole newRole) {
        player.setRole(newRole);
    }
    
    private void assignLeaderRoleToHighestRanked() {
        CityPlayer maxPlayer = members.stream()
            .max(Comparator.comparing(member -> member.getRole().ordinal()))
            .orElse(null);
    
        if (maxPlayer != null) {
            maxPlayer.setRole(CityRole.LEADER);
        }
    }
    
    private CityPlayer findPlayerByName(String name) {
            for (CityPlayer player : this.members) {
                if(player.getName().equals(name)) {
                    return player;
                }
            }
            return null;
    }
}
