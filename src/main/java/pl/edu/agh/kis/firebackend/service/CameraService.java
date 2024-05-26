package pl.edu.agh.kis.firebackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.edu.agh.kis.firebackend.configuration.DeclaredQueues;
import pl.edu.agh.kis.firebackend.model.Camera;

@Service
@AllArgsConstructor
public class CameraService {
    private final RabbitMQ rmq;
    private final ObjectMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(CameraService.class);

    public void sendMessage(Camera camera) throws JsonProcessingException {
        rmq.send(mapper.writeValueAsBytes(camera));
    }

    @RabbitListener(queues = DeclaredQueues.CAMERA_QUEUE_NAME)
    private void receiveMessage(Message message) {
        try {
            Camera camera = mapper.readValue(message.getBody(), Camera.class);
            log.error(camera.toString());
        } catch (Exception e) {
        }
    }
}
