package org.cmucreatelab.flutter_android.classes.sensors;

import java.io.Serializable;

/**
 * Created by Steve on 8/11/2016.
 *
 * NoSensor
 *
 * A class that represents no sensor.
 *
 */
public class NoSensor extends A_Sensor implements Sensor, Serializable {

    private static final Sensor.Type sensorType = Type.NO_SENSOR;


    public NoSensor() {
        // empty
    }


    @Override
    public Type getSensorType() {
        return sensorType;
    }


    @Override
    public int getSensorReading() {
        return 0;
    }

}
