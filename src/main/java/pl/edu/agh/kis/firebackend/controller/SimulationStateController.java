package pl.edu.agh.kis.firebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.kis.firebackend.model.simulation.SimulationStateDto;
import pl.edu.agh.kis.firebackend.service.SimulationStateService;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@AllArgsConstructor
public class SimulationStateController {
    private SimulationStateService simulationStateService;

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SimulationStateDto> runSimulation(@RequestParam(required = false, defaultValue = "5") long interval) {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(interval));

        return intervalFlux.map(tick -> SimulationStateDto.from(simulationStateService.currentState()));
    }
}
