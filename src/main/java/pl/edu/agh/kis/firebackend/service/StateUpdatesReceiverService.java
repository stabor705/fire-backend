package pl.edu.agh.kis.firebackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Delivery;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.rabbitmq.Receiver;

import java.io.IOException;

@Service
@AllArgsConstructor
public class StateUpdatesReceiverService {
    private Receiver receiver;
    private ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(StateUpdatesReceiverService.class);

    public <T> Flux<T> createUpdatesFlux(String queueName, Class<T> Tclass) {
        return receiver.consumeNoAck(queueName)
                .mapNotNull(message -> {
                    try {
                        return parseMessage(message, Tclass);
                    } catch (IOException e) {
                        log.error("Failed to deserialize {}: {}", Tclass.toString(), e.toString());
                        return null;
                    }
                });
    }

    private <T> T parseMessage(Delivery delivery, Class<T> Tclass) throws IOException {
        return mapper.readValue(delivery.getBody(), Tclass);
    }

}
