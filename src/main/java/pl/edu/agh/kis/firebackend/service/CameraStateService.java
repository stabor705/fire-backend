package pl.edu.agh.kis.firebackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.configuration.DeclaredQueues;
import pl.edu.agh.kis.firebackend.model.Camera;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class CameraStateService {
    private final StateUpdatesReceiverService stateUpdatesReceiverService;

    public Flux<Camera> camerasFlux() {
        return stateUpdatesReceiverService.createUpdatesFlux(DeclaredQueues.CAMERA_QUEUE_NAME, Camera.class);
    }

//    public void sendMessages() {
//        Flux<Camera> cameras = Flux.range(0, 10)
//                .map(idx -> new Camera(idx, new Date(), new Location(1, 1))
//        );
//        Flux<OutboundMessage> messages = cameras.map(it -> {
//            try {
//                return new OutboundMessage("", DeclaredQueues.CAMERA_QUEUE_NAME, mapper.writeValueAsBytes(it));
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        sender.sendWithPublishConfirms(messages)
//                .doOnError(e -> log.error(e.toString()))
//                .subscribe(m -> {
//                    if (m.isAck()) {
//                        log.info("Message sent");
//                    }
//                });
//    }
}
