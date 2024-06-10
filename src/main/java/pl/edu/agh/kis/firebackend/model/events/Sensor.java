package pl.edu.agh.kis.firebackend.model.events;

import pl.edu.agh.kis.firebackend.model.primitives.Location;

import java.util.Date;

public interface Sensor<T> {
    int sensorId();
    Date timestamp();
    SensorType sensorType();
    Location location();
    T data();
}
