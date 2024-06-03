package pl.edu.agh.kis.firebackend.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.configuration.DeclaredQueues;
import pl.edu.agh.kis.firebackend.model.FireBrigade;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class FireBrigadeStateService  {
    private final StateUpdatesReceiverService stateUpdatesReceiverService;
    private static final Logger log = LoggerFactory.getLogger(CameraStateService.class);

    public Flux<FireBrigade> fireBrigadesFlux() {
        return stateUpdatesReceiverService.createUpdatesFlux(DeclaredQueues.FIRE_BRIGADE_QUEUE_NAME, FireBrigade.class);
    }
}
