package pl.edu.agh.kis.firebackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.kis.firebackend.model.Camera;
import pl.edu.agh.kis.firebackend.model.Location;
import pl.edu.agh.kis.firebackend.service.CameraService;

import java.util.Date;

@RestController
public class CameraController {
    private final CameraService cameraService;

    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @PostMapping
    public void sendHelloWorld() throws JsonProcessingException {
        cameraService.sendMessage(new Camera(1, new Date(), new Location(12, 12)));
    }
}
