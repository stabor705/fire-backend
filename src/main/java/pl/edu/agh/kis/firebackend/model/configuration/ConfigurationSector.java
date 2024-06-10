package pl.edu.agh.kis.firebackend.model.configuration;

import pl.edu.agh.kis.firebackend.model.simulation.SectorState;

public record ConfigurationSector(
    int sectorId,
    int row,
    int column,
    SectorState initialState
) {
}
