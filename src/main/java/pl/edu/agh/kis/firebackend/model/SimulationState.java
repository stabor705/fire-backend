package pl.edu.agh.kis.firebackend.model;

import lombok.AllArgsConstructor;
import pl.edu.agh.kis.firebackend.model.configuration.Configuration;
import pl.edu.agh.kis.firebackend.model.primitives.Direction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class SimulationState{
    public String forestName;
    public Date timestamp;
    public List<Sector> sectors;
    public SimulationState() {
        this.forestName = "Wolski";
        this.timestamp = new Date();
        this.sectors = new ArrayList<>(List.of(
            new Sector(0, new SectorState(
                    new Date(),
                    0,
                    0,
                    Direction.NE,
                    0,
                    0,
                    0,
                    0
            ))
        ));
    }

    public static SimulationState fromConfiguration(Configuration configuration) {
        return new SimulationState(
                configuration.forestName(),
                new Date(),
                configuration.sectors().stream().map(Sector::fromConfig).toList()
        );
    }
}
