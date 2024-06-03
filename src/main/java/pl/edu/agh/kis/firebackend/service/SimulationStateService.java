package pl.edu.agh.kis.firebackend.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.model.SimulationState;
import pl.edu.agh.kis.firebackend.model.configuration.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;

@Service
@AllArgsConstructor
public class SimulationStateService {
    private final ConfigurationService configurationService;
    private final WindSpeedSensorUpdatesService windSpeedSensorUpdatesService;

    private SimulationState state;

    public SimulationState currentState() {
        return state;
    }

    @PostConstruct
    private void init() {
        Configuration configuration = configurationService.getConfiguration();
        this.state = SimulationState.fromConfiguration(configuration);
    }
}
