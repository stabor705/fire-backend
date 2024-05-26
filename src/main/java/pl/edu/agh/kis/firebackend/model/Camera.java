package pl.edu.agh.kis.firebackend.model;

import java.util.Date;

record CameraData(
    boolean smokeDetected,
    double smokeLevel,
    Location smokeLocation
) {}

public record Camera(
    int cameraId,
    Date timestamp,
    Location location
) {}
