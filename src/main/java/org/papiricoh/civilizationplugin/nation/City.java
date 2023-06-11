package org.papiricoh.civilizationplugin.nation;

import org.papiricoh.civilizationplugin.nation.range.CityType;
import org.papiricoh.civilizationplugin.player.Player;

import java.util.ArrayList;

public class City {
    private String name;
    private CityType city_type;
    private ArrayList<Player> members;

    public City(String name, CityType city_type) {
        this.name = name;
        this.city_type = city_type;
        this.members = new ArrayList<>();
    }

    public void addPlayer() {

    }
}
