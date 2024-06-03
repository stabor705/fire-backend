package pl.edu.agh.kis.firebackend.model.configuration;

import pl.edu.agh.kis.firebackend.model.SectorState;

public record ConfigurationSector(
    int sectorId,
    int row,
    int column,
    SectorState initialState
) {
}
