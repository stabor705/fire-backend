package pl.edu.agh.kis.firebackend.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.model.events.FireBrigade;
import pl.edu.agh.kis.firebackend.model.simulation.ForesterPatrol;
import pl.edu.agh.kis.firebackend.model.simulation.SimulationState;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class SimulationStateService {
    private SimulationState state;

    private Flux<FireBrigade> fireBrigadeFlux;
    private Flux<ForesterPatrol> foresterPatrolFlux;

    public SimulationState currentState() {
        return state;
    }

    @PostConstruct
    private void init() {
        fireBrigadeFlux.subscribe(fireBrigade -> {
            Integer key = fireBrigade.fireBrigadeId();
            state.fireBrigades.put(key, fireBrigade);
        });

        foresterPatrolFlux.subscribe(foresterPatrol -> {
            Integer key = foresterPatrol.foresterPatrolId();
            state.foresterPatrols.put(key, foresterPatrol);
        });
    }
}
