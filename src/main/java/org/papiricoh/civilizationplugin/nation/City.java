package org.papiricoh.civilizationplugin.nation;

import org.papiricoh.civilizationplugin.nation.range.CityType;
import org.papiricoh.civilizationplugin.player.CityPlayer;
import org.papiricoh.civilizationplugin.player.roles.CityRole;

import java.util.ArrayList;

public class City {
    private String name;
    private String pre_name;
    private CityType city_type;
    private ArrayList<CityPlayer> members;


    public City(String name) {
        this.name = name;
        this.city_type = CityType.SETTLEMENT;
        this.members = new ArrayList<>();
    }

    public City(String name, CityType city_type) {
        this.name = name;
        this.city_type = city_type;
        this.members = new ArrayList<>();
    }

    public void addPlayer(CityPlayer player) {
        this.members.add(player);
    }

    public ArrayList<CityPlayer> getMembers() {
        return this.members;
    }

    public void setPreName(String pre_name) {
        this.pre_name = pre_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.pre_name + " " + this.name;
    }

    public CityPlayer getPlayerByName(String name) {
        return findPlayerByName(name);
    }

    public boolean changePlayerRole(String user_player, String target_player, int new_role) {
        CityPlayer user_player_obj = findPlayerByName(user_player);
        if(user_player.equals(target_player) && user_player_obj != null && this.members.size() > 1) {
            user_player_obj.setRole(CityRole.values()[new_role]);
            int max_role = 0;
            CityPlayer max_player = null;
            for (int i = 0; i < this.members.size(); i++) {
                if( max_role < this.members.get(i).getRole().ordinal()) {
                    max_role = this.members.get(i).getRole().ordinal();
                    max_player = this.members.get(i);
                }
            }
            max_player.setRole(CityRole.LEADER);
            return true;

        }else if(user_player_obj != null && user_player_obj.getRole() == CityRole.LEADER) {
            CityPlayer target_player_obj = findPlayerByName(target_player);
            if(target_player_obj != null) {
                target_player_obj.setRole(CityRole.values()[new_role]);
                return true;
            }
            return false;
        }
        return false;
    }

    private CityPlayer findPlayerByName(String name) {
        for (int i = 0; i < this.members.size(); i++) {
            if(this.members.get(i).getName().equals(name)) {
                return this.members.get(i);
            }
        }
        return null;
    }
}
