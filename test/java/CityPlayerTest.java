import org.junit.Test;
import org.papiricoh.civilizationplugin.nation.City;
import org.papiricoh.civilizationplugin.nation.range.CityType;
import org.papiricoh.civilizationplugin.player.CityPlayer;
import org.papiricoh.civilizationplugin.player.roles.CityRole;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class CityPlayerTest {

    @Test
    public void CityLeaderChangesRoleToMemberTest() {
        CityPlayer cp1 = new CityPlayer(UUID.randomUUID(), "Papiricoh", CityRole.LEADER.ordinal());
        CityPlayer cp2 = new CityPlayer(UUID.randomUUID(), "Dark Annata", CityRole.HIGH_OFFICIAL.ordinal());
        CityPlayer cp3 = new CityPlayer(UUID.randomUUID(), "Lith Lotia", CityRole.CITIZEN.ordinal());
        City tCity = new City("Lothalia", CityType.SETTLEMENT);
        tCity.addPlayer(cp1);
        tCity.addPlayer(cp2);
        tCity.addPlayer(cp3);
        tCity.changePlayerRole(cp1.getName(), cp2.getName(), CityRole.OFFICIAL.ordinal());

        assertEquals(CityRole.OFFICIAL, tCity.getPlayerByName(cp2.getName()).getRole());
    }

    @Test
    public void CityNotLeaderChangesRoleToMemberTest() {
        CityPlayer cp1 = new CityPlayer(UUID.randomUUID(), "Papiricoh", CityRole.LEADER.ordinal());
        CityPlayer cp2 = new CityPlayer(UUID.randomUUID(), "Dark Annata", CityRole.HIGH_OFFICIAL.ordinal());
        CityPlayer cp3 = new CityPlayer(UUID.randomUUID(), "Lith Lotia", CityRole.CITIZEN.ordinal());
        City tCity = new City("Lothalia", CityType.SETTLEMENT);
        tCity.addPlayer(cp1);
        tCity.addPlayer(cp2);
        tCity.addPlayer(cp3);
        tCity.changePlayerRole(cp3.getName(), cp2.getName(), CityRole.OFFICIAL.ordinal());

        assertEquals(CityRole.HIGH_OFFICIAL, tCity.getPlayerByName(cp2.getName()).getRole());
    }

    @Test
    public void CityLeaderChangesRoleToHimselfTest() {
        CityPlayer cp1 = new CityPlayer(UUID.randomUUID(), "Papiricoh", CityRole.LEADER.ordinal());
        CityPlayer cp2 = new CityPlayer(UUID.randomUUID(), "Dark Annata", CityRole.HIGH_OFFICIAL.ordinal());
        CityPlayer cp3 = new CityPlayer(UUID.randomUUID(), "Lith Lotia", CityRole.CITIZEN.ordinal());
        City tCity = new City("Lothalia", CityType.SETTLEMENT);
        tCity.addPlayer(cp1);
        tCity.addPlayer(cp2);
        tCity.addPlayer(cp3);
        tCity.changePlayerRole(cp1.getName(), cp1.getName(), CityRole.OFFICIAL.ordinal());

        assertEquals(CityRole.LEADER, tCity.getPlayerByName(cp2.getName()).getRole());
    }
}