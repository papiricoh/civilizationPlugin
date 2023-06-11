package org.papiricoh.civilizationplugin.nation;

import java.util.ArrayList;

public class Nation {
    private String name;
    private ArrayList<City> cities;
    private String capital_name;

    public Nation(String name, City capital) {
        this.name = name;
        this.cities = new ArrayList<>();
        this.cities.add(capital);
        this.capital_name = capital.getName();
    }

    public String getCapital_name() {
        return capital_name;
    }

    public String getName() {
        return name;
    }
}
