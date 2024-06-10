package pl.edu.agh.kis.firebackend.model.simulation;

import lombok.AllArgsConstructor;
import pl.edu.agh.kis.firebackend.model.FireBrigadeState;
import pl.edu.agh.kis.firebackend.model.ForesterPatrolState;
import pl.edu.agh.kis.firebackend.model.events.FireBrigade;
import pl.edu.agh.kis.firebackend.model.primitives.Location;

import java.util.*;

@AllArgsConstructor
public class SimulationState {
    public String forestName;
    public Date timestamp;
    public Map<Integer, Sector> sectors;
    public Map<Integer, FireBrigade> fireBrigades;
    public Map<Integer, ForesterPatrol> foresterPatrols;

    public SimulationState() {
        this.forestName = "";
        this.timestamp = new Date();
        this.sectors = new HashMap<>();
        this.fireBrigades = new HashMap<>();
        this.fireBrigades.put(1, new FireBrigade(1, FireBrigadeState.AVAILABLE, new Date(), new Location(1.0, 1.0)));
        this.foresterPatrols = new HashMap<>();
        this.foresterPatrols.put(1, new ForesterPatrol(1, new Date(), ForesterPatrolState.PATROLLING, new Location(1.0, 1.0), new Location(12.0, 12.0)));
    }
}
