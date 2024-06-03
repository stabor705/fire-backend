package pl.edu.agh.kis.firebackend.model;

import pl.edu.agh.kis.firebackend.model.primitives.Location;

import java.util.Date;

public record FireBrigade(
    int fireBrigadeId,
    State state,
    Date timestamp,
    Location location
) {
    public enum Action {
        GO_TO_BASE,
        EXTINGUISHING
    }

    public enum State {
        AVAILABLE,
        TRAVELLING,
        PATROLLING
    }
}
