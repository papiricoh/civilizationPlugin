package org.papiricoh.civilizationplugin.player;

import java.util.UUID;

public class Player {
    private UUID uuid;
    private String name;

    public Player(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
