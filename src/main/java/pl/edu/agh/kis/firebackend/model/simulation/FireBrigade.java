package pl.edu.agh.kis.firebackend.model.simulation;

import pl.edu.agh.kis.firebackend.model.FireBrigadeAction;
import pl.edu.agh.kis.firebackend.model.FireBrigadeState;
import pl.edu.agh.kis.firebackend.model.primitives.Location;

public record FireBrigade(
    int fireBrigadeId,
    int sectorId,
    Location location,
    FireBrigadeState state,
    FireBrigadeAction action
) { }
