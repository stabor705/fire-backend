package pl.edu.agh.kis.firebackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.kis.firebackend.model.Camera;
import pl.edu.agh.kis.firebackend.service.CameraStateService;
import reactor.core.publisher.Flux;

@RestController()
@RequestMapping("/camerea")
public class CameraController {
    private final CameraStateService cameraService;

    public CameraController(CameraStateService cameraService) {
        this.cameraService = cameraService;
    }

//    @PostMapping
//    public void sendHelloWorld() throws JsonProcessingException {
//        cameraService.sendMessages();
//    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Camera> cameraStream() {
        return cameraService.camerasFlux();
    }
}
