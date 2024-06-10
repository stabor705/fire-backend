package pl.edu.agh.kis.firebackend.model.simulation;

import lombok.AllArgsConstructor;
import pl.edu.agh.kis.firebackend.model.configuration.ConfigurationSector;

@AllArgsConstructor
public class Sector {
    public int sectorId;
    public SectorState state;

    public static Sector fromConfig(ConfigurationSector sector) {
        return new Sector(sector.sectorId(), sector.initialState());
    }
}
