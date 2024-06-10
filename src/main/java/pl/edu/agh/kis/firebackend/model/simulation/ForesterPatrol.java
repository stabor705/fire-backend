package pl.edu.agh.kis.firebackend.model.simulation;

import pl.edu.agh.kis.firebackend.model.ForesterPatrolState;
import pl.edu.agh.kis.firebackend.model.primitives.Location;

import java.util.Date;

public record ForesterPatrol(
    int foresterPatrolId,
    Date timestamp,
    ForesterPatrolState state,
    Location baseLocation,
    Location currentLocation
) {
}
