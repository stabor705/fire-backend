package pl.edu.agh.kis.firebackend.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.kis.firebackend.model.UpdatesQueue;
import pl.edu.agh.kis.firebackend.model.events.FireBrigade;
import pl.edu.agh.kis.firebackend.model.simulation.ForesterPatrol;
import pl.edu.agh.kis.firebackend.service.StateUpdatesService;
import reactor.core.publisher.Flux;

@Configuration
@AllArgsConstructor
public class DeclaredQueues {
    private final StateUpdatesService stateUpdatesService;

    @Bean
    Flux<FireBrigade> fireBrigadeUpdates() {
        return stateUpdatesService.createUpdatesFlux(new UpdatesQueue<>("updates.fireBrigade", FireBrigade.class));
    }

    @Bean
    Flux<ForesterPatrol> foresterPatrolUpdates() {
        return stateUpdatesService.createUpdatesFlux(new UpdatesQueue<>("updates.foresterPatrol", ForesterPatrol.class));
    }
}
