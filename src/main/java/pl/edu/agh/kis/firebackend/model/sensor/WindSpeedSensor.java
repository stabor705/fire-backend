package pl.edu.agh.kis.firebackend.model.sensor;

import pl.edu.agh.kis.firebackend.model.primitives.Location;

import java.util.Date;

public record WindSpeedSensor(
    int sensorId,
    Date timestamp,
    SensorType sensorType,
    Location location,
    WindSpeedData data
) implements Sensor<WindSpeedData> {}
