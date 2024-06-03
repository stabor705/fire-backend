package pl.edu.agh.kis.firebackend.model.configuration;

import pl.edu.agh.kis.firebackend.model.primitives.Location;
import pl.edu.agh.kis.firebackend.model.sensor.SensorType;

import java.util.Date;

public record Sensor(
    int sensorId,
    SensorType sensorType,
    Location location,
    Date timestamp
) {
}
