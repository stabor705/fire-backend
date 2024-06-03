package pl.edu.agh.kis.firebackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.configuration.DeclaredQueues;
import pl.edu.agh.kis.firebackend.model.sensor.WindSpeedSensor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class WindSpeedSensorUpdatesService {
    private final StateUpdatesReceiverService stateUpdatesReceiverService;

    public Flux<WindSpeedSensor> windSpeedSensorFlux() {
        return stateUpdatesReceiverService.createUpdatesFlux(DeclaredQueues.WIND_SPEED_QUEUE_NAME, WindSpeedSensor.class);
    }
}
