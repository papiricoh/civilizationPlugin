package org.papiricoh.civilizationplugin.player;

import org.papiricoh.civilizationplugin.player.roles.CityRole;

import java.util.UUID;

public class CityPlayer extends Player {
    private CityRole role;

    public CityPlayer(UUID uuid, String name) {
        super(uuid, name);
        this.role = CityRole.IMMIGRANT;
    }

    public CityPlayer(UUID uuid, String name, int role_id) {
        super(uuid, name);
        this.role = CityRole.values()[role_id];
    }

    public CityRole getRole() {
        return role;
    }
    public void setRole(CityRole role) {
        this.role = role;
    }
}
