package org.papiricoh.civilizationplugin.nation;

import org.papiricoh.civilizationplugin.nation.range.CityRange;

public class City {
    private String name;
    private CityRange city_range;

    public City(String name, CityRange city_range) {
        this.name = name;
        this.city_range = city_range;
    }


}
