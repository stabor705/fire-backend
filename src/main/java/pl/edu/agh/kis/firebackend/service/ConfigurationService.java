package pl.edu.agh.kis.firebackend.service;

import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.model.primitives.Direction;
import pl.edu.agh.kis.firebackend.model.primitives.Location;
import pl.edu.agh.kis.firebackend.model.SectorState;
import pl.edu.agh.kis.firebackend.model.configuration.Configuration;
import pl.edu.agh.kis.firebackend.model.configuration.ConfigurationSector;

import java.util.Date;
import java.util.List;

@Service
public class ConfigurationService {
    public Configuration getConfiguration() {
        return new Configuration(
                "Wolski-forest",
                "Wolski",
                0,
                0,
                0,
                "",
                List.of(
                        new Location(1, 1),
                        new Location(2, 1),
                        new Location(2, 2),
                        new Location(1, 2)
                ),
                List.of(new ConfigurationSector(0, 0, 0, new SectorState(
                        new Date(),
                        0,
                        0,
                        Direction.NE,
                        0,
                        0,
                        0,
                        0
                ))),
                List.of()
        );
    }
}
